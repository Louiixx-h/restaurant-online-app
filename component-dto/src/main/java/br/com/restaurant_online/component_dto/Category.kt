package br.com.restaurant_online.component_dto

import com.google.gson.annotations.SerializedName

class Category(
    @SerializedName("title") val title: String,
    @SerializedName("foods") val foods: List<Food>
)