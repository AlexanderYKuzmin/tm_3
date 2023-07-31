package com.kuzmin.tm_3.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kuzmin.tm_3.data.database.model.*

@Database(entities = [BuildingDb::class, SectionDb::class, MeasurementDb::class, ResultDb::class, PhotoDb::class], version = 1)
abstract class TmDatabase : RoomDatabase(){
    companion object {

        private var db: TmDatabase? = null
        private const val DB_NAME = "local_tm.db"
        private val LOCK = Any()

        fun getInstance(context: Context): TmDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        TmDatabase::class.java,
                        DB_NAME
                    )
                        //.createFromAsset("database/asbd_2.db")
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun chatContactsDao(): TmDao
}