package com.siar.siardelivery.data

import com.siar.siardelivery.domain.model.LoginRequest
import kotlinx.coroutines.delay
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
class LoginRepository @Inject constructor() {

    suspend fun doLogin(request: LoginRequest): Boolean{
        delay(3000)
        return true
    }
}