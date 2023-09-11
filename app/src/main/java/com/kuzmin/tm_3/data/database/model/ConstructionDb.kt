package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.sql.Date

@Entity(tableName = "measure_constructions")
data class ConstructionDb(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val uuid: String,

    val latitude: Double,

    val longitude: Double,

    @ColumnInfo(name = "num_of_secs")
    val numOfSecs: Int,

    val height: Int,

    @ColumnInfo(name = "construction_type")
    val type: String,

    val config: Int,

    @ColumnInfo(name = "num_of_levels")
    val numOfLevels: Int,                       //measure_levels

    @ColumnInfo(name = "start_level")
    val startLevel: Int,

    @ColumnInfo(name = "creator_id")
    val creatorId: Long,

    @ColumnInfo(name = "creation_date")     //yyyy-MM-dd, sql.Date
    val crDate: Date,

    @ColumnInfo(name = "employee_id")
    val employeeId: Long,

    @ColumnInfo(name = "completed_date")
    val completedDate: Date,   // yyyy-MM-dd

    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean,

    @ColumnInfo(name = "site_id")
    val siteId: Long,
)