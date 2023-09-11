package com.kuzmin.tm_3.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kuzmin.tm_3.data.database.model.*
import com.kuzmin.tm_3.data.database.type_converters.DateConverter

@Database(entities = [
    SiteDb::class,
    SiteEquipmentDb::class,
    AddressDb::class,
    SiteConfigurationDb::class,
    ConstructionDb::class,
    GroupDb::class,
    LevelDb::class,
    SectionDb::class,
    MeasurementDb::class,
    ResultDb::class,
    PhotoDb::class,
    UserDb::class], version = 2)
@TypeConverters(DateConverter::class)
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

    abstract fun tmDao(): TmDao
}