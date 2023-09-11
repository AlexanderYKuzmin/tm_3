package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sites_configurations")
data class SiteConfigurationDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val name: String,

    val latitude: Double,

    val longitude: Double,

    val type: Int,

    @ColumnInfo(name = "type_description")
    val typeDescription: String,

    @ColumnInfo(name = "site_id")
    val siteId: Long
)
