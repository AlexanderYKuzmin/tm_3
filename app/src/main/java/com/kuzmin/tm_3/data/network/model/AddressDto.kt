package com.kuzmin.tm_3.data.network.model

data class AddressDto(
    val id: Long,
    val country: String,
    val region : String,
    val subRegion: String,
    val city: String,
    val street: String?,
    val building: String,
    val postalCode: Int?,
    val regionCode: Int?
)
