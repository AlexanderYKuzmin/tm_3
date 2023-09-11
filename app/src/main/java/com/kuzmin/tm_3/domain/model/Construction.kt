package com.kuzmin.tm_3.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.kuzmin.tm_3.domain.util.Coordinates
import java.util.Date

data class Construction(
    val id: Long,

    val coordinates: Coordinates,

    val height: Int,

    val numOfSecs: Int,

    val type: ConstructionType,

    val config: ConstructionConfig,

    val numOfLevels: Int,

    val startAltitude: Int,

    val crDate: Date,

    val completedDate: Date,

    val isCompleted: Boolean,

    val userId: Long,

    val siteId: Long,

    val uuid: String,
) {
}
