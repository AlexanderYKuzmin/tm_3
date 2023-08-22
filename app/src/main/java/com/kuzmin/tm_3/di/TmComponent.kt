package com.kuzmin.tm_3.di

import android.app.Application
import com.kuzmin.tm_3.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class, DataModule::class])
interface TmComponent {

    fun inject(activity: MainActivity)

    fun getBuildingSubComponent(): BuildingSubComponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): TmComponent
    }
}