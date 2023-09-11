package com.kuzmin.tm_3.di

import com.kuzmin.tm_3.data.network.ApiFactory
import com.kuzmin.tm_3.data.network.ApiService
import com.kuzmin.tm_3.data.repository.TmRepositoryRemoteImpl
import com.kuzmin.tm_3.domain.TmRepositoryRemote
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface NetworkModule {
    @Binds
    fun bindRepositoryRemote(tmRepositoryRemoteImpl: TmRepositoryRemoteImpl): TmRepositoryRemote

    companion object {
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}