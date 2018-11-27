package com.anderson.androidtrend.di.components

import com.anderson.androidtrend.TestApplication
import com.anderson.androidtrend.di.modules.ActivityModule
import com.anderson.androidtrend.di.modules.TestAppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, TestAppModule::class, ActivityModule::class])
interface TestAppComponent : AppComponent{

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(testApplication: TestApplication): Builder
    }
}