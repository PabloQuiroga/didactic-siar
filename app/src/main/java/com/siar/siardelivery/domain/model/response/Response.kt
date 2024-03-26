package com.siar.siardelivery.domain.model.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 14/03/2024
 *****/
@Parcelize
data class Response(
    val name: Name,
    val gender: String,
    val email: String,
    val location: Location,
    val dob: Dob,
    val phone: String,
    val cell: String,
    val picture: Picture
): Parcelable
