package com.siar.siardelivery.data.model

import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Location

data class LocationDto(
    @SerializedName("street")
    val street: StreetDto,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: String,
    @SerializedName("coordinates")
    val coordinates: CoordinatesDto,
    @SerializedName("timezone")
    val timezone: TimezoneDto,
) {
    fun toDomain() = Location(
        street = this.street.toDomain(),
        city = this.city,
        state = this.state,
        country = this.country,
        postcode = this.postcode,
        coordinates = this.coordinates.toDomain()
    )
}
