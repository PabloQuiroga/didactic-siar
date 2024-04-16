package com.siar.siardelivery.domain

import com.siar.siardelivery.data.util.Resource
import com.siar.siardelivery.domain.model.request.LoginRequest
import com.siar.siardelivery.domain.model.response.Response
import com.siar.siardelivery.domain.repository.LoginRepository
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(loginRequest: LoginRequest): Resource<Response> {
        return loginRepository.doLogin(loginRequest)
    }
}
