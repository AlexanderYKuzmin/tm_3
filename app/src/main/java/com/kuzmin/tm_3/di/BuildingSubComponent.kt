package com.kuzmin.tm_3.di

import com.kuzmin.tm_3.ui.nav_constructions.ConstructionFragment
import com.kuzmin.tm_3.ui.nav_constructions.NavSitesListFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface BuildingSubComponent {

    fun inject(navSitesListFragment: NavSitesListFragment)

    fun inject(constructionFragment: ConstructionFragment)
}