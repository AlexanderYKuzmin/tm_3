package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("measure_groups")
data class GroupDb(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "group_num")
    val groupNum: Int,

    val azimuth: Int,

    @ColumnInfo(name = "theo_distance")
    val theoDistance: Int,

    @ColumnInfo(name = "theo_distance")
    val theoHeight: Int,

    @ColumnInfo(name = "building_id")
    val buildingId: Long
)