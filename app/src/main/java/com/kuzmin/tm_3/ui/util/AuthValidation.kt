package com.kuzmin.tm_3.ui.util

import com.kuzmin.tm_3.AppConstants
import com.kuzmin.tm_3.domain.model.AuthUser
import java.util.*

object AuthValidation {
    /*fun isAuthUserValid(authUser: AuthUser): Boolean {
        return if (authUser.token != AppConstants.NO_TOKEN && authUser.dateToken != AppConstants.NO_DATE) {
            val currentTime = Date().time
            val tokenExpirationTime =
                authUser.dateToken + AppConstants.TOKEN_LIFE_TIME - AppConstants.DEVIATION_TOKEN_LIFE_TIME
            currentTime < tokenExpirationTime
        } else false
    }*/

    fun isTokenValid(token: String, tokenDate: Long) : Boolean {
        return if (token.trim().length > 10) {
            val currentTime = Date().time
            val tokenExpirationTime = tokenDate + AppConstants.TOKEN_LIFE_TIME - AppConstants.DEVIATION_TOKEN_LIFE_TIME
            currentTime < tokenExpirationTime
        } else false
    }

    fun isPasswordConsistent(password: String): Boolean {
        return password.trim().length > 7
    }
}