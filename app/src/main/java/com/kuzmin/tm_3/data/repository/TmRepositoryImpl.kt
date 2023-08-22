package com.kuzmin.tm_3.data.repository

import com.kuzmin.tm_3.data.database.TmDao
import com.kuzmin.tm_3.data.database.TmDatabase
import com.kuzmin.tm_3.domain.TmRepository
import javax.inject.Inject

class TmRepositoryImpl @Inject constructor(
    private val tmDao: TmDao
)  : TmRepository {

}