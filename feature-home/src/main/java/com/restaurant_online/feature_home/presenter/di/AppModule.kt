package com.restaurant_online.feature_home.presenter.di

import com.restaurant_online.feature_home.presenter.presenter.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {
    viewModel { HomeViewModel(get()) }
}