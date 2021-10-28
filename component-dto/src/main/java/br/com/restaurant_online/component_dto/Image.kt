package br.com.restaurant_online.component_dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class Image(
    @SerializedName("formats") val formats: ImageFormat,
    @SerializedName("url") val url: String
)

@Serializable
class ImageFormat(
    @SerializedName("large") val large: ImageType,
    @SerializedName("small") val small: ImageType,
    @SerializedName("medium") val medium: ImageType,
    @SerializedName("thumbnail") val thumbnail: ImageType,
)

@Serializable
class ImageType(
    @SerializedName("url") val url: String
)