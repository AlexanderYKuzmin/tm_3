package com.kuzmin.tm_3.data.database

import androidx.room.*
import com.kuzmin.tm_3.data.database.model.*

@Dao
abstract class TmDao {

    /*@Query("SELECT * FROM buildings")
    abstract suspend fun getAll(): List<BuildingWithSectionsMeasurementsResultsDb>

    @Query("SELECT * FROM buildings WHERE id = :id")
    abstract suspend fun getBuildingById(id: Long): BuildingWithSectionsMeasurementsResultsDb

    @Query("SELECT * FROM buildings WHERE name LIKE :name")
    abstract suspend fun getBuildingsByName(name: String): List<BuildingWithSectionsMeasurementsResultsDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addBuilding(building: ConstructionDb): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addBuildings(buildings: List<ConstructionDb>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addSections(sections: List<SectionDb>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addMeasurements(measurements: List<MeasurementDb>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addResults(results: List<ResultDb>): List<Long>

    @Transaction
    open suspend fun addBuildingSMR(buildingSMR: BuildingWithSectionsMeasurementsResultsDb) {
        with(buildingSMR) {
            addBuilding(building)
            addSections(sections)
            addMeasurements(measurements)
            addResults(results)
        }
    }

    @Update
    abstract suspend fun updateBuilding(building: ConstructionDb)

    @Update
    abstract suspend fun updateSections(sections: List<SectionDb>): Int

    @Update
    abstract suspend fun updateMeasurements(measurements: List<MeasurementDb>): Int

    @Update
    abstract suspend fun updateResults(measurements: List<ResultDb>): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun updatePhotos(photos: List<PhotoDb>): Int

    @Transaction
    open suspend fun updateBuildingSMR(buildingSMR: BuildingWithSectionsMeasurementsResultsDb) {
        with(buildingSMR) {
            updateBuilding(building)
            updateSections(sections)
            updateMeasurements(measurements)
            updateResults(results)
        }
    }

    @Delete
    abstract fun deleteBuilding(building: ConstructionDb)*/

}