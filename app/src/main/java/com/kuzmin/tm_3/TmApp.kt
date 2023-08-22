package com.kuzmin.tm_3

import android.app.Application
import com.kuzmin.tm_3.di.DaggerTmComponent
import com.kuzmin.tm_3.di.TmComponent

class TmApp : Application() {

    lateinit var component: TmComponent

    override fun onCreate() {
        component = DaggerTmComponent.factory().create(this)
        super.onCreate()
    }
}