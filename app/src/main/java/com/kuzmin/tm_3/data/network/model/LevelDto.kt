package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LevelDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("number")
    @Expose
    val number: Int,

    @SerializedName("positionOfSec")
    @Expose
    val positionOfSec: String,

    @SerializedName("altitude")
    @Expose
    val altitude: Int
)
