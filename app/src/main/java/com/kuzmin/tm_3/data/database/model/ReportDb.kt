package com.kuzmin.tm_3.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reports")
data class ReportDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long
)
