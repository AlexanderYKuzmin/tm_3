package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "buildings")
data class BuildingDb(

    @PrimaryKey
    val id: Long,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val type: String,

    @ColumnInfo
    val config: Int,

    @ColumnInfo
    val height: Int,

    @ColumnInfo(name = "num_of_secs")
    val numOfSecs: Int,

    @ColumnInfo(name = "start_level")
    val startLevel: Int,

    @ColumnInfo(name = "cr_date")
    val crDate: Date,

    @ColumnInfo(name = "coordinates_dec")
    val coordinatesDec: Double,

    @ColumnInfo
    val completed: Boolean,

    @ColumnInfo
    val approved: Boolean,

    @ColumnInfo(name = "user_id")
    val userId: Long
)