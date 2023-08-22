package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class MeasurementDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val circle: String,

    @ColumnInfo(name = "left_angle")
    val left: Double,

    @ColumnInfo(name = "right_angle")
    val right: Double,

    @ColumnInfo(name = "group_id")
    val groupId: Int
)
