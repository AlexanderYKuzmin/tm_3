package com.kuzmin.tm_3.domain.model

import java.util.Date

data class Building(
val id: Long,
val name: String,
val type: BuildingType,
val config: BuildingConfig,
val height: Int,
val numOfSecs: Int,
val startLevel: Int,
val crDate: Date,
val coordinates: String,  // xx.xxxx yy.yyyyy
val completed: Boolean,
val approved: Boolean,
val userId: Long
)
