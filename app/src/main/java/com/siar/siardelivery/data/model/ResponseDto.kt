package com.siar.siardelivery.data.model

import com.google.gson.annotations.SerializedName
import com.siar.siardelivery.domain.model.response.Response

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
data class ResponseDto(
    @SerializedName("results")
    val results: List<ResultDto>
) {
    fun toDomain() = Response(
        name = this.results[0].name.toDomain(),
        gender = this.results[0].gender,
        email = this.results[0].email,
        location = this.results[0].location.toDomain(),
        dob = this.results[0].dob.toDomain(),
        phone = this.results[0].phone,
        cell = this.results[0].cell,
        picture = this.results[0].picture.toDomain()
    )
}
