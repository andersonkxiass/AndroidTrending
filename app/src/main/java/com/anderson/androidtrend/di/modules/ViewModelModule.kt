package com.anderson.androidtrend.di.modules

import androidx.lifecycle.ViewModel
import com.anderson.androidtrend.di.ViewModelKey
import com.anderson.androidtrend.features.details.DetailsViewModel
import com.anderson.androidtrend.features.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(viewModel : DetailsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel : MainViewModel) : ViewModel
}