package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("measure_levels")
data class LevelDb(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "order_number")
    val orderNumber: Int,

    @ColumnInfo(name = "position_on_sec")
    val positionOnSec: String,

    @ColumnInfo(name = "measure_level_mm")
    val measureLevelMm: Int,

    @ColumnInfo(name = "building_id")
    val buildingId: Long
)
