package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sections")
data class SectionDb(

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val number: Int,

    @ColumnInfo(name = "w_bottom")
    val wBottom: Int,

    @ColumnInfo(name = "w_top")
    val wTop: Int,

    @ColumnInfo
    val height: Int,

    @ColumnInfo
    val level: Int,

    @ColumnInfo(name = "construction_id")
    val constructionId: Long,

    @ColumnInfo(name = "construction_uuid")
    val constructionUuid: String
)
