package br.com.restaurant_online.component_domain

import br.com.restaurant_online.component_dto.Category
import br.com.restaurant_online.component_repository.RestaurantOnlineRepository

class RestaurantUseCaseImpl(
    private val repository: RestaurantOnlineRepository
): RestaurantUseCase {

    override suspend fun findAllCategories(): List<Category> {
        return try {
            repository.findAllCategories() ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun findAllCategoriesMock(): List<Category> {
        return repository.findAllCategoriesMock()
    }
}