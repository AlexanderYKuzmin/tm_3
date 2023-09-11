package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    val averageCl: Double,

    val averageCr: Double,

    val averageClCr: Double,

    val shiftDeg: Double,

    val shiftMm: Int,

    val tanAlfa: Double,

    val distToMeasureLevel: Int,

    val distDelta: Int,

    val betaAverageLeft: Double,

    val betaAverageRight: Double,

    val betaDelta: Int,

    val measurementId: Int
)
