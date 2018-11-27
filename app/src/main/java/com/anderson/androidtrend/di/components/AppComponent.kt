package com.anderson.androidtrend.di.components

import android.app.Application
import com.anderson.androidtrend.HubApplication
import com.anderson.androidtrend.di.modules.ActivityModule
import com.anderson.androidtrend.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent {

    fun inject(hubApp: HubApplication)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}