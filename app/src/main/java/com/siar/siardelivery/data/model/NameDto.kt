package com.siar.siardelivery.data.model


import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Name

data class NameDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
){
    fun toDomain() = Name(
        title = this.first,
        first = this.first,
        last = this.last
    )
}
