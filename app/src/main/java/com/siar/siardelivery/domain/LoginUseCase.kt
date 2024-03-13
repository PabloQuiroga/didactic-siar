package com.siar.siardelivery.domain

import com.siar.siardelivery.data.LoginRepository
import com.siar.siardelivery.domain.model.LoginRequest
import kotlinx.coroutines.delay
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 11/03/2024
 *****/
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(loginRequest: LoginRequest): Boolean{
        return loginRepository.doLogin(loginRequest)
    }
}