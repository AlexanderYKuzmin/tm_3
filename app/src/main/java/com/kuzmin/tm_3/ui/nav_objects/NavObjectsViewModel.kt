package com.kuzmin.tm_3.ui.nav_objects

import android.app.Application
import androidx.lifecycle.ViewModel
import com.kuzmin.tm_3.domain.usecases.GetAllBuildingsSimpleLocalUseCase
import javax.inject.Inject

class NavObjectsViewModel @Inject constructor(
    application: Application,
val getAllBuildingsSimpleLocalUseCase: GetAllBuildingsSimpleLocalUseCase
) : ViewModel() {

}