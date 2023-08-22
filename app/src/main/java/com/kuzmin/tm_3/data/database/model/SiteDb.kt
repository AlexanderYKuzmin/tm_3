package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("sites")
data class SiteDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val name: String,

    val description: String,

    @ColumnInfo(name = "tenant_id")
    val tenantId: Long
)
