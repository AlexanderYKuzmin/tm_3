package com.kuzmin.tm_3.domain.usecases

import com.kuzmin.tm_3.domain.TmRepository
import com.kuzmin.tm_3.domain.model.ConstructionSimple
import javax.inject.Inject

class GetAllBuildingsSimpleLocalUseCase @Inject constructor(
    val tmRepository: TmRepository
) {
    operator fun invoke() = listOf<ConstructionSimple>()
}