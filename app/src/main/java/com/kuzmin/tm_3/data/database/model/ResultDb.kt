package com.kuzmin.tm_3.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class ResultDb(

    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "average_cl")
    val averageCl: Double,

    @ColumnInfo(name = "average_cr")
    val averageCr: Double,

    @ColumnInfo(name = "average_cl_cr")
    val averageClCr: Double,

    @ColumnInfo(name = "shift_deg")
    val shiftDeg: Double,

    @ColumnInfo(name = "shift_mm")
    val shiftMm: Int,

    @ColumnInfo(name = "tan_alfa")
    val tanAlfa: Double,

    @ColumnInfo(name = "dist_to_section")
    val distToSection: Int,

    @ColumnInfo(name = "dist_delta")
    val distDelta: Int,

    @ColumnInfo(name = "beta_average")
    val betaAverage: Double,

    @ColumnInfo(name = "beta_i")
    val betaI: Double,

    @ColumnInfo(name = "beta_delta")
    val betaDelta: Int,

    @ColumnInfo(name = "measurement_id")
    val measurementId: Long,

    @ColumnInfo(name = "measurement_uuid")
    val measurementUUID: String
)
