package com.kuzmin.tm_3.domain.usecases

import com.kuzmin.tm_3.domain.TmRepository
import com.kuzmin.tm_3.domain.model.Construction
import javax.inject.Inject

class GetBuildingByArgumentLocalUseCase @Inject constructor(
    val repository: TmRepository
) {

    suspend fun getBuildingById(id: Long): Construction? {
        return null
    }

    suspend fun getBuildingByName(name: String): Construction? {
        return null
    }
}