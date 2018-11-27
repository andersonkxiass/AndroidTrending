package com.anderson.androidtrend.di.modules

import com.anderson.androidtrend.features.details.DetailsActivity
import com.anderson.androidtrend.features.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDetailsActivity(): DetailsActivity
}