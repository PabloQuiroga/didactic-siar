package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Dob

data class DobDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("age")
    val age: Int
){
    fun toDomain() = Dob(
        date = this.date,
        age = this.age
    )
}
