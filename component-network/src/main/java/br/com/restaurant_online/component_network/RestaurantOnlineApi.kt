package br.com.restaurant_online.component_network

import br.com.restaurant_online.component_dto.Category
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantOnlineApi {

    @GET("categories")
    suspend fun findAllCategories(): Response<List<Category>>
}