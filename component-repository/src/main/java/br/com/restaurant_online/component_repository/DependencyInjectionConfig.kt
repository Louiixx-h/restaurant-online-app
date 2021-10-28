package br.com.restaurant_online.component_repository

import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single { RestaurantOnlineRepositoryImpl(get()) } bind RestaurantOnlineRepository::class
}