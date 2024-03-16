package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName

data class RegisteredDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("age")
    val age: Int
)
