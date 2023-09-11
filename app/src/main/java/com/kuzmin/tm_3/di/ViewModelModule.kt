package com.kuzmin.tm_3.di

import androidx.lifecycle.ViewModel
import com.kuzmin.tm_3.ui.MainActivityViewModel
import com.kuzmin.tm_3.ui.login.LoginFragmentViewModel
import com.kuzmin.tm_3.ui.nav_constructions.BuildingFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    @Binds
    fun bindMainActivityViewModel(viewModel:MainActivityViewModel): ViewModel

    @IntoMap
    @ViewModelKey(BuildingFragmentViewModel::class)
    @Binds
    fun bindChatContactsViewModel(viewModel: BuildingFragmentViewModel): ViewModel

    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    @Binds
    fun bindLoginFragmentViewModel(viewModel: LoginFragmentViewModel): ViewModel
}