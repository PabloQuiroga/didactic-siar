package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Coordinates

data class CoordinatesDto(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
){
    fun toDomain() = Coordinates(
        latitude = this.latitude,
        longitude = this.longitude
    )
}
