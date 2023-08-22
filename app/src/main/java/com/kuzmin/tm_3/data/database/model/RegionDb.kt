package com.kuzmin.tm_3.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "regions")
data class RegionDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val name: String,

    val index: Int,

    val code: Int
)
