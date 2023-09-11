package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("id")
    @Expose
    val id: Long,


    val name: String,

    @SerializedName("date")
    @Expose
    val date: String,


    val url: String
)
