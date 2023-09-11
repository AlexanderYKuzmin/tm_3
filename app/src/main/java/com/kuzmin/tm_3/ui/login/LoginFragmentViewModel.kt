package com.kuzmin.tm_3.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzmin.tm_3.AppConstants
import com.kuzmin.tm_3.data.datastore.PrefManager
import com.kuzmin.tm_3.data.datastore.UserScheme
import com.kuzmin.tm_3.data.network.ApiService
import com.kuzmin.tm_3.domain.model.AuthUser
import com.kuzmin.tm_3.domain.usecases.GetUserWithTokenUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class LoginFragmentViewModel @Inject constructor(
    val prefManager: PrefManager,
    val apiService: ApiService,
    val getUserWithTokenUseCase: GetUserWithTokenUseCase
) : ViewModel() {

    private val _authUserData = MutableLiveData<AuthUser>()
    val authUserData: LiveData<AuthUser> get() = _authUserData

    fun readAuthUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _authUserData.postValue(
                prefManager.readData(
                    UserScheme.USERNAME,
                    UserScheme.PASSWORD,
                    UserScheme.TOKEN,
                    UserScheme.TOKEN_DATE,
                    UserScheme.REMOTE_ID,
                    UserScheme.FIRST_NAME,
                    UserScheme.LAST_NAME
                )
            )
        }
    }

    fun getUser(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserWithTokenUseCase(username, password)

            val authUser = user.copy(password = password)
            _authUserData.postValue(authUser)
        }
    }

    fun writeAuthUser(authUser: AuthUser) {
        viewModelScope.launch(Dispatchers.IO) {
            with(authUser) {
                prefManager.writeData(
                    username,
                    password,
                    token,
                    dateToken,
                    remoteId,
                    firstName,
                    lastName
                )
            }
        }
    }

    fun isTokenValid(dateMillis: Long): Boolean {
        val currentTime = Date().time
        val tokenExpirationTime = dateMillis + AppConstants.TOKEN_LIFE_TIME - AppConstants.DEVIATION_TOKEN_LIFE_TIME
        return currentTime < tokenExpirationTime
    }

    fun isPasswordConsistent(password: String): Boolean {
        return password.trim().length > 7
    }
}