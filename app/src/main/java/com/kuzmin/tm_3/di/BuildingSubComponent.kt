package com.kuzmin.tm_3.di

import com.kuzmin.tm_3.ui.nav_objects.BuildingFragment
import com.kuzmin.tm_3.ui.nav_objects.NavObjectsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface BuildingSubComponent {

    fun inject(navObjectsFragment: NavObjectsFragment)

    fun inject(buildingFragment: BuildingFragment)
}