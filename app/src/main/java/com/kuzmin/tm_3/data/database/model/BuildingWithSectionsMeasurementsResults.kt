package com.kuzmin.tm_3.data.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class BuildingWithSectionsMeasurementsResultsDb(
    @Embedded
    val building: BuildingDb,

    @Relation(parentColumn = "id", entityColumn = "buildingId")
    val sections: List<SectionDb>,

    @Relation(parentColumn = "id", entityColumn = "buildingId")
    val measurements: List<MeasurementDb>,

    @Relation(parentColumn = "id", entityColumn = "buildingId")
    val results: List<ResultDb>
)
