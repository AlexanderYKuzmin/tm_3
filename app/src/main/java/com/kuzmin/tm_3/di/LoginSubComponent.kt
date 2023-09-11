package com.kuzmin.tm_3.di

import com.kuzmin.tm_3.ui.login.LoginFragment
import dagger.Subcomponent
import javax.inject.Inject

@Subcomponent(modules = [ViewModelModule::class, NetworkModule::class])
interface LoginSubComponent {

    fun inject(loginFragment: LoginFragment)
}