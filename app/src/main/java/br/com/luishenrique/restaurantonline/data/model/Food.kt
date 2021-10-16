package br.com.luishenrique.restaurantonline.data.model

import br.com.luishenrique.restaurantonline.utils.DisponibilityEnum
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

class Food(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: BigDecimal,
    @SerializedName("delivery") val delivery: Boolean,
    @SerializedName("disponibility") val disponibility: DisponibilityEnum,
    @SerializedName("images") val images: List<Image>,
)