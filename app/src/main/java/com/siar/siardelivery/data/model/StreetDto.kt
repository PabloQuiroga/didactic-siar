package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Street

data class StreetDto(
    @SerializedName("number")
    val number: Int,
    @SerializedName("name")
    val name: String
){
    fun toDomain() = Street(
        number = this.number,
        name = this.name
    )
}
