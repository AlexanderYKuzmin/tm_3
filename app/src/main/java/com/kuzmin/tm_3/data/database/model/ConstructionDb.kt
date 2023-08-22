package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measure_constructions")
data class ConstructionDb(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val latitude: Double,

    val longitude: Double,

    val height: Int,

    @ColumnInfo(name = "num_of_secs")
    val numOfSecs: Int,

    val type: String,

    val config: Int,

    @ColumnInfo(name = "num_of_levels")
    val numOfLevels: Int,

    @ColumnInfo(name = "start_level")
    val startLevel: Int,

    @ColumnInfo(name = "cr_date")
    val crDate: String,

    @ColumnInfo(name = "completed_date")
    val completedDate: String,   // format

    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean,

    @ColumnInfo(name = "employee_name")
    val employeeName: String,

    @ColumnInfo(name = "site_id")
    val siteId: Long,

    val uuid: String
)