package br.com.restaurant_online.component_domain.di

import br.com.restaurant_online.component_domain.RestaurantUseCase
import br.com.restaurant_online.component_domain.RestaurantUseCaseImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    single { RestaurantUseCaseImpl(get()) } bind RestaurantUseCase::class
}