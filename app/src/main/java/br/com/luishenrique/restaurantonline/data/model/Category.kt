package br.com.luishenrique.restaurantonline.data.model

import com.google.gson.annotations.SerializedName

class Category(
    @SerializedName("title") val title: String,
    @SerializedName("foods") val foods: List<Food>
)