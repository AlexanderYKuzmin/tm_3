package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addresses")
data class AddressDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val country: String,

    val region: String,

    @ColumnInfo(name = "sub_region")
    val subRegion: String,

    val city: String,

    val street: String,

    val building: String,

    @ColumnInfo(name = "postal_code")
    val postalCode: Int,

    @ColumnInfo(name = "region_code")
    val regionCode: Int
)
