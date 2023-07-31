package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class MeasurementDb(
    @PrimaryKey
    val id: Long,

    @ColumnInfo
    val number: Int,

    @ColumnInfo
    val side: Int,

    @ColumnInfo
    val circle: String,

    @ColumnInfo
    val left: Double,

    @ColumnInfo
    val right: Double,

    @ColumnInfo(name = "theo_height")
    val theoHeight: Int,

    @ColumnInfo
    val distance: Int,

    @ColumnInfo
    val baseTop: String,

    @ColumnInfo(name = "sec_num")
    val secNum: Int,

    @ColumnInfo
    val azimuth: Int,

    @ColumnInfo
    val contractor: String,

    @ColumnInfo(name = "building_id")
    val buildingId: Long,

    @ColumnInfo(name = "sections_id")
    val sectionId: Long,

    @ColumnInfo(name = "results_id")
    val resultId: Long
)
