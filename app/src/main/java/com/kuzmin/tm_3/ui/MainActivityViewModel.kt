package com.kuzmin.tm_3.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.kuzmin.tm_3.domain.model.BuildingSimple
import com.kuzmin.tm_3.domain.usecases.GetAllBuildingsSimpleLocalUseCase
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    application: Application,
    val getAllBuildingsSimpleLocalUseCase: GetAllBuildingsSimpleLocalUseCase
) : ViewModel() {

    fun getBuildingList() = getAllBuildingsSimpleLocalUseCase()
}