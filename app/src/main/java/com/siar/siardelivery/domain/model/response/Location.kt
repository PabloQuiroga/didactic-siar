package com.siar.siardelivery.domain.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 15/03/2024
 *****/
@Parcelize
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates
) : Parcelable
