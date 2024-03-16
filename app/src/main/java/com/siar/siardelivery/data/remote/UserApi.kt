package com.siar.siardelivery.data.remote

import com.siar.siardelivery.data.model.ResponseDto
import retrofit2.http.GET

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
interface UserApi {

    @GET("api/")
    suspend fun fetchUser(): ResponseDto
}
