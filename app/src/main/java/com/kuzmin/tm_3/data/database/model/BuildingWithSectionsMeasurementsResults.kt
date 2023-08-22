package com.kuzmin.tm_3.data.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class BuildingWithSectionsMeasurementsResultsDb(
    @Embedded
    val building: ConstructionDb,

    @Relation(parentColumn = "id", entityColumn = "building_id")
    val sections: List<SectionDb>,

    @Relation(parentColumn = "id", entityColumn = "building_id")
    val measurements: List<MeasurementDb>,

    @Relation(parentColumn = "id", entityColumn = "building_id")
    val results: List<ResultDb>
)
