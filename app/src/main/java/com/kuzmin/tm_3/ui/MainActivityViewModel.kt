package com.kuzmin.tm_3.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzmin.tm_3.AppConstants.DEVIATION_TOKEN_LIFE_TIME
import com.kuzmin.tm_3.AppConstants.TOKEN_LIFE_TIME
import com.kuzmin.tm_3.AppConstants.NO_DATE
import com.kuzmin.tm_3.AppConstants.NO_TOKEN
import com.kuzmin.tm_3.data.datastore.PrefManager
import com.kuzmin.tm_3.data.datastore.UserScheme.FIRST_NAME
import com.kuzmin.tm_3.data.datastore.UserScheme.LAST_NAME
import com.kuzmin.tm_3.data.datastore.UserScheme.PASSWORD
import com.kuzmin.tm_3.data.datastore.UserScheme.REMOTE_ID
import com.kuzmin.tm_3.data.datastore.UserScheme.TOKEN
import com.kuzmin.tm_3.data.datastore.UserScheme.TOKEN_DATE
import com.kuzmin.tm_3.data.datastore.UserScheme.USERNAME
import com.kuzmin.tm_3.domain.model.AuthUser
import com.kuzmin.tm_3.domain.usecases.GetAllBuildingsSimpleLocalUseCase
import com.kuzmin.tm_3.domain.usecases.GetUserWithTokenUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    application: Application,
    val prefManager: PrefManager,
    val getAllConstructionsSimpleLocalUseCase: GetAllBuildingsSimpleLocalUseCase,
    val getUserWithTokenUseCase: GetUserWithTokenUseCase,

    ) : ViewModel() {

    private val _authUserData = MutableLiveData<AuthUser>()
    val authUserData: LiveData<AuthUser> get() = _authUserData

    private val _isAuthUserValid = MutableLiveData<Boolean>()
    val isAuthUserValid: LiveData<Boolean> get() = _isAuthUserValid

    fun getConstructionList() = getAllConstructionsSimpleLocalUseCase()

    fun handleLoadSitesFromServer() {
        CoroutineScope(Dispatchers.IO).launch {
            println(getUserWithTokenUseCase("admin", "h98dGDJx"))
        }
    }

    fun loadAuthUser() {
        viewModelScope.launch {
            val authUser = prefManager.readData(
                USERNAME,
                PASSWORD,
                TOKEN,
                TOKEN_DATE,
                REMOTE_ID,
                FIRST_NAME,
                LAST_NAME
            )
            _authUserData.postValue(authUser)
        }
    }

    /*fun isAuthUserValid(authUser: AuthUser): Boolean {
        return if (authUser.token != NO_TOKEN && authUser.dateToken != NO_DATE) {
            val currentTime = Date().time
            val tokenExpirationTime = authUser.dateToken + TOKEN_LIFE_TIME - DEVIATION_TOKEN_LIFE_TIME
            currentTime < tokenExpirationTime
        } else false
    }*/
}