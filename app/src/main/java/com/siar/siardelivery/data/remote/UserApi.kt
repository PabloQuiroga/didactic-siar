package com.siar.siardelivery.data.remote

import com.siar.siardelivery.data.model.ResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 24/03/2024
 *****/
const val GET_MOCK_USER = "https://randomuser.me/api/"

interface UserApi {

    /**
     * To use dynamic URL
     * full url needed
     *
     * for more info, see...
     * https://stackoverflow.com/questions/49975854/is-it-possible-to-use-multiple-baseurl-in-retrofit
     * or much more info in...
     * https://futurestud.io/tutorials/retrofit-2-how-to-use-dynamic-urls-for-requests
     */
    @GET //("api/")
    suspend fun fetchUser(@Url fullUrl: String): Response<ResponseDto>
}
