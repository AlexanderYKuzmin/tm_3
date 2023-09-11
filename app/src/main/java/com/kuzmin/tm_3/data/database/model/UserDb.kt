package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    val username: String,

    val token: String,

    @ColumnInfo(name = "user_id_remote")
    val userIdRemote: Long
)
