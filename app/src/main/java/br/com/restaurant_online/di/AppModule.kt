package br.com.restaurant_online.di

import br.com.restaurant_online.component_domain.RestaurantUseCase
import br.com.restaurant_online.component_domain.RestaurantUseCaseImpl
import br.com.restaurant_online.presenter.main.viewmodel.RestaurantViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.bind

val domainModule = module {
    single { br.com.restaurant_online.component_domain.RestaurantUseCaseImpl(get()) } bind br.com.restaurant_online.component_domain.RestaurantUseCase::class
}

val presenterModule = module {
    viewModel { RestaurantViewModel(get()) }
}

val appModules = listOf(
    presenterModule, domainModule
)