package com.kuzmin.tm_3.data.network.model

data class SiteConfigurationDto(
    val id: Long,

    val latitude: Double?,
    val longitude: Double?,
    val type: Int,
    val description: String?
)
