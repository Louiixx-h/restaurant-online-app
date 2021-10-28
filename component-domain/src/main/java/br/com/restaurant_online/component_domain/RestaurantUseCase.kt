package br.com.restaurant_online.component_domain

import br.com.restaurant_online.component_dto.Category

interface RestaurantUseCase {
    suspend fun findAllCategories(): List<Category>
    fun findAllCategoriesMock(): List<Category>
}