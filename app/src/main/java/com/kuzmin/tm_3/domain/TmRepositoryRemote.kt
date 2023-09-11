package com.kuzmin.tm_3.domain

import com.kuzmin.tm_3.data.database.model.SiteDb
import com.kuzmin.tm_3.data.network.model.UserDto
import com.kuzmin.tm_3.domain.model.AuthUser
import java.util.*

interface TmRepositoryRemote {

    suspend fun getUserWithToken(username: String, password: String): AuthUser

    fun getAll()

    fun getSitesByNameAndDate(name: String, startDate: Date, endDate: Date)

    fun getSitesByDate(startDate: Date, endDate: Date)

    fun getSitesByName(name: String)

    fun getSitesById(ids: List<Long>): List<SiteDb>

    fun addConstructions()
}