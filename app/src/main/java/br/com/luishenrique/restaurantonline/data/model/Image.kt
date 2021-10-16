package br.com.luishenrique.restaurantonline.data.model

import com.google.gson.annotations.SerializedName

class Image(
    @SerializedName("formats") val formats: ImageFormat,
    @SerializedName("url") val url: String
)

class ImageFormat(
    @SerializedName("large") val large: ImageType,
    @SerializedName("small") val small: ImageType,
    @SerializedName("medium") val medium: ImageType,
    @SerializedName("thumbnail") val thumbnail: ImageType,
)

class ImageType(
    @SerializedName("url") val url: String
)