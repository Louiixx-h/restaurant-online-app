package br.com.restaurant_online.component_repository

import br.com.restaurant_online.component_dto.Category

interface RestaurantOnlineRepository {
    suspend fun findAllCategories(): List<Category>?
    fun findAllCategoriesMock(): List<Category>
}