package br.com.luishenrique.restaurantonline.data.network

import br.com.luishenrique.restaurantonline.data.model.Category
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantOnlineApi {

    @GET("categories")
    suspend fun findAllCategories(): Response<List<Category>>
}