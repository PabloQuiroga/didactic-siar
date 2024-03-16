package com.siar.siardelivery.domain.model.response

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 15/03/2024
 *****/
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Street(
    val number: Int,
    val name: String
)
