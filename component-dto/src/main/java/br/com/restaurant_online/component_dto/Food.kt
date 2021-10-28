package br.com.restaurant_online.component_dto

import br.com.restaurant_online.utils.DisponibilityEnum
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Food(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    @SerializedName("delivery") val delivery: Boolean,
    @SerializedName("disponibility") val availability: DisponibilityEnum,
    @SerializedName("images") val images: List<Image>,
)