package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class MeasurementDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val uuid: String,

    val circle: String,

    @ColumnInfo(name = "left_angle")
    val left: Double,

    @ColumnInfo(name = "right_angle")
    val right: Double,

    @ColumnInfo(name = "group_id")
    val groupId: Int,

    @ColumnInfo(name = "level_id")
    val levelId: Long,

    @ColumnInfo(name = "construction_id")
    val constructionId: Long,

    @ColumnInfo(name = "construction_uuid")
    val constructionUUID: String,

    @ColumnInfo(name = "group_uuid")
    val groupUUID: String,

    @ColumnInfo(name = "level_uuid")
    val levelUUID: String
)
