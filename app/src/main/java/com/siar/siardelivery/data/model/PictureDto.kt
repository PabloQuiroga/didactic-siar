package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Picture

data class PictureDto(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
){
    fun toDomain() = Picture(
        large = this.large,
        medium = this.medium,
        thumbnail = this.thumbnail
    )
}
