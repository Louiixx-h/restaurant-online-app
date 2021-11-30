package br.com.restaurant_online.component_repository.di

import br.com.restaurant_online.component_repository.RestaurantOnlineRepository
import br.com.restaurant_online.component_repository.RestaurantOnlineRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single { RestaurantOnlineRepositoryImpl(get()) } bind RestaurantOnlineRepository::class
}