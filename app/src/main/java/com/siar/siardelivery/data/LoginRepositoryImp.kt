package com.siar.siardelivery.data

import com.siar.siardelivery.data.remote.UserService
import com.siar.siardelivery.domain.model.LoginRequest
import com.siar.siardelivery.domain.model.response.Response
import com.siar.siardelivery.domain.repository.LoginRepository
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
class LoginRepositoryImp @Inject constructor(
    private val service: UserService
): LoginRepository {

    override suspend fun doLogin(request: LoginRequest): Response {
        val response = service.getUser()
        return response.toDomain()
    }
}
