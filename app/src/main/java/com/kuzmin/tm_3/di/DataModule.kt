package com.kuzmin.tm_3.di

import android.app.Application
import com.kuzmin.tm_3.data.database.TmDao
import com.kuzmin.tm_3.data.database.TmDatabase
import com.kuzmin.tm_3.data.repository.TmRepositoryImpl
import com.kuzmin.tm_3.domain.TmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRepository(repositoryImpl: TmRepositoryImpl): TmRepository

    companion object {

        @Provides
        fun provideTmDao(application: Application): TmDao {
            return TmDatabase.getInstance(application).tmDao()
        }
    }
}