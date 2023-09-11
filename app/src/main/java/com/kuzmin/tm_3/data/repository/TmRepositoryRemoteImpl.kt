package com.kuzmin.tm_3.data.repository

import com.kuzmin.tm_3.AppConstants.NO_PASSWORD
import com.kuzmin.tm_3.data.database.model.SiteDb
import com.kuzmin.tm_3.data.network.ApiService
import com.kuzmin.tm_3.data.network.model.UserSignInDto
import com.kuzmin.tm_3.domain.TmRepositoryRemote
import com.kuzmin.tm_3.domain.model.AuthUser
import java.util.*
import javax.inject.Inject

class TmRepositoryRemoteImpl @Inject constructor(
    private val apiService: ApiService
) : TmRepositoryRemote{
    override suspend fun getUserWithToken(username: String, password: String): AuthUser {
        val user = apiService.getUser(UserSignInDto(username, password))
        return AuthUser(
            username = user.username,
            password = NO_PASSWORD,
            token = user.token,
            dateToken = Date().time,
            remoteId = user.userIdRemote,
            firstName = user.firstName,
            lastName = user.lastName
        )
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getSitesByNameAndDate(name: String, startDate: Date, endDate: Date) {
        TODO("Not yet implemented")
    }

    override fun getSitesByDate(startDate: Date, endDate: Date) {
        TODO("Not yet implemented")
    }

    override fun getSitesByName(name: String) {
        TODO("Not yet implemented")
    }

    override fun getSitesById(ids: List<Long>): List<SiteDb> {
        TODO("Not yet implemented")
    }

    override fun addConstructions() {
        TODO("Not yet implemented")
    }
}