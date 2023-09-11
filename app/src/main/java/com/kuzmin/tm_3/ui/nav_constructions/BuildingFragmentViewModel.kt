package com.kuzmin.tm_3.ui.nav_constructions

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuzmin.tm_3.domain.model.Construction
import com.kuzmin.tm_3.domain.usecases.GetBuildingByArgumentLocalUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class BuildingFragmentViewModel @Inject constructor(
    application: Application,
    val getBuildingByArgumentLocalUseCase: GetBuildingByArgumentLocalUseCase
) : ViewModel() {

    private val _buildingLd = MutableLiveData<Construction>()
    val buildingLd: LiveData<Construction> get() = _buildingLd

    fun getBuildingLocalById(id: Long) {
        viewModelScope.launch {
            val building = getBuildingByArgumentLocalUseCase.getBuildingById(id) ?:
            throw java.lang.RuntimeException("Wrong id")
            _buildingLd.postValue(building)
        }
    }
}