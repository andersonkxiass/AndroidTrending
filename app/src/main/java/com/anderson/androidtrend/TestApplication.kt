package com.anderson.androidtrend

import com.anderson.androidtrend.di.components.DaggerTestAppComponent

class TestApplication : HubApplication() {

    override fun onCreate() {
        super.onCreate()

        DaggerTestAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}