package com.kuzmin.tm_3.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    val userIdRemote: Long,

    val token: String,

    val username: String,

    val firstName: String,

    val lastName: String
)