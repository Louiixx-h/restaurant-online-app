package com.restaurant_online.feature_home.presenter.di

import br.com.restaurant_online.component_domain.RestaurantUseCase
import br.com.restaurant_online.component_domain.RestaurantUseCaseImpl
import com.restaurant_online.feature_home.presenter.presenter.viewmodel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val presenterModule = module {
    //single { RestaurantUseCaseImpl(get()) } bind RestaurantUseCase::class
    viewModel { HomeViewModel(get()) }
}