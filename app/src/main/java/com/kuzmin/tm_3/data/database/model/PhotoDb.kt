package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class PhotoDb(
    @PrimaryKey
    val id: Long,

    @ColumnInfo
    val name: String,

    @ColumnInfo
    val date: Date,

    @ColumnInfo(name = "ftp_url")
    val ftpUrl: String,

    @ColumnInfo(name = "building_id")
    val buildingId: Long,
)
