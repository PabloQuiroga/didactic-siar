package com.siar.siardelivery.domain.repository

import com.siar.siardelivery.data.util.Resource
import com.siar.siardelivery.domain.model.request.LoginRequest
import com.siar.siardelivery.domain.model.response.Response

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 14/03/2024
 *****/
interface LoginRepository {
    suspend fun doLogin(request: LoginRequest): Resource<Response>
}
