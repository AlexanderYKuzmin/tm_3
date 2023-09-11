package com.kuzmin.tm_3.data.datastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.Preferences.*
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.kuzmin.tm_3.AppConstants.NO_DATE
import com.kuzmin.tm_3.AppConstants.NO_ID
import com.kuzmin.tm_3.AppConstants.NO_NAME
import com.kuzmin.tm_3.AppConstants.NO_PASSWORD
import com.kuzmin.tm_3.AppConstants.NO_TOKEN
import com.kuzmin.tm_3.AppConstants.NO_USER
import com.kuzmin.tm_3.data.datastore.UserScheme.FIRST_NAME
import com.kuzmin.tm_3.data.datastore.UserScheme.LAST_NAME
import com.kuzmin.tm_3.data.datastore.UserScheme.PASSWORD
import com.kuzmin.tm_3.data.datastore.UserScheme.REMOTE_ID
import com.kuzmin.tm_3.data.datastore.UserScheme.TOKEN
import com.kuzmin.tm_3.data.datastore.UserScheme.TOKEN_DATE
import com.kuzmin.tm_3.data.datastore.UserScheme.USERNAME
import com.kuzmin.tm_3.domain.model.AuthUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class PrefManager @Inject constructor(
    val application: Application
) {
    val dataStore = application.dataStore

    suspend fun writeData(
        username: String,
        password: String,
        token: String = NO_TOKEN,
        dateToken: Long = NO_DATE,
        remoteId: Long = NO_ID,
        firstName: String,
        lastName: String,
    ) {
        dataStore.edit { prefs ->
            prefs[USERNAME] = username
            prefs[PASSWORD] = password
            prefs[TOKEN] = token
            prefs[TOKEN_DATE] = dateToken
            prefs[REMOTE_ID] = remoteId
            prefs[FIRST_NAME] = firstName
            prefs[LAST_NAME] = lastName
        }
    }

    suspend fun readData(
        keyUsername: Key<String>,
        keyPassword: Key<String>,
        keyToken: Key<String>,
        keyDateToken: Key<Long>,
        keyRemoteId: Key<Long>,
        keyFirstName: Key<String>,
        keyLastName: Key<String>,
    ): AuthUser {
        val flowValue = dataStore.data.map { prefs ->
            val username = prefs[keyUsername] ?: NO_USER
            val password = prefs[keyPassword] ?: NO_PASSWORD
            val token = prefs[keyToken] ?: NO_TOKEN
            val dateToken = prefs[keyDateToken] ?: NO_DATE
            val remoteId = prefs[keyRemoteId] ?: NO_ID
            val firstName = prefs[keyFirstName] ?: NO_NAME
            val lastName = prefs[keyLastName] ?: NO_NAME

            AuthUser(username, password, token, dateToken, remoteId, firstName, lastName)
        }
        return runBlocking(Dispatchers.IO) { flowValue.first() }
    }
}