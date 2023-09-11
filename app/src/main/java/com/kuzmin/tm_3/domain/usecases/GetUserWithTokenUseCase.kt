package com.kuzmin.tm_3.domain.usecases

import com.kuzmin.tm_3.domain.TmRepositoryRemote
import javax.inject.Inject

class GetUserWithTokenUseCase @Inject constructor(
    private val repositoryRemote: TmRepositoryRemote
) {
    suspend operator fun invoke(username: String, password: String) =
        repositoryRemote.getUserWithToken(username, password)
}