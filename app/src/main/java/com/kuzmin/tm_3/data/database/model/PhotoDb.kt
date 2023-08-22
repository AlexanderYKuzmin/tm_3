package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "photos")
data class PhotoDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val name: String,

    val date: String, // dd.MM.yyyy

    @ColumnInfo(name = "ftp_url")
    val ftpUrl: String,

    @ColumnInfo(name = "site_id")
    val siteId: Long
)
