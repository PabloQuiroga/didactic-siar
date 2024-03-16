package com.siar.siardelivery.domain

import com.siar.siardelivery.domain.model.LoginRequest
import com.siar.siardelivery.domain.model.response.Response
import com.siar.siardelivery.domain.repository.LoginRepository
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

    suspend operator fun invoke(loginRequest: LoginRequest): Response {
        return loginRepository.doLogin(loginRequest)
    }
}
