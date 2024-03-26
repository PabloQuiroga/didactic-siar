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
data class Dob(
    val date: String,
    val age: Int
): Parcelable
