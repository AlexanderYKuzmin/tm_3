package com.kuzmin.tm_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.kuzmin.tm_3.domain.model.ConstructionConfig
import com.kuzmin.tm_3.domain.model.ConstructionType
import java.util.Date

data class ConstructionDto(
    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("uuid")
    @Expose
    val uuid: String?,

    @SerializedName("latitude")
    @Expose
    val latitude: Double?,

    @SerializedName("longitude")
    @Expose
    val longitude: Double?,

    @SerializedName("numOfSections")
    @Expose
    val numOfSections: Int,

    @SerializedName("height")
    @Expose
    val height: Int,

    @SerializedName("type")
    @Expose
    val type: ConstructionType,

    @SerializedName("config")
    @Expose
    val config: ConstructionConfig,

    @SerializedName("measureLevels")
    @Expose
    val measureLevels: Int,

    val startAltitude: Int,

    val creationDate: Date,

    val completedDate: Date,

    val isCompleted: Boolean,

    val userDto: UserDto?,

    val sections: List<SectionDto>,

    val levels: List<LevelDto>,

    val measureGroups: List<GroupDto>,

    val measurements: List<MeasurementDto>,

    val results: List<ResultDto>
)
