package com.kuzmin.tm_3

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.kuzmin.tm_3.data.database.TmDao
import com.kuzmin.tm_3.data.database.TmDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class TmDaoTest {

    private lateinit var db: TmDatabase
    private lateinit var dao: TmDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TmDatabase::class.java).build()

        dao = db.tmDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun createBuildingTest() {

    }
}