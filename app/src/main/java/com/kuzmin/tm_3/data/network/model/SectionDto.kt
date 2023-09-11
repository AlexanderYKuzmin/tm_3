package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SectionDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @Expose
    val number: Int,

    @Expose
    val wBottom: Int,

    @Expose
    val wTop: Int,

    @Expose
    val height: Int
)
