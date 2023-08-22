package com.kuzmin.tm_3.domain.usecases

import com.kuzmin.tm_3.domain.TmRepository
import com.kuzmin.tm_3.domain.model.Building
import javax.inject.Inject

class GetBuildingByArgumentLocalUseCase @Inject constructor(
    val repository: TmRepository
) {

    suspend fun getBuildingById(id: Long): Building? {
        return null
    }

    suspend fun getBuildingByName(name: String): Building? {
        return null
    }
}