package com.kuzmin.tm_3.data.network.model

data class SiteDto(
    val id: Long,

    val name: String,

    val description: String,

    val tenantId: Long,

    val address: AddressDto,

    val configuration: SiteConfigurationDto,

    val reports: List<ReportDto>,

    val photos: List<PhotoDto>,

    val siteEquipments: List<SiteEquipmentDto>,

    val construction: ConstructionDto
)
