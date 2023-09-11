package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MeasurementDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    val leftAngleCl: Double,

    val leftAngleCr: Double,

    val rightAngleCl: Double,

    val rightAngleCr: Double,

    val groupId: Long,

    val levelId: Long
)
