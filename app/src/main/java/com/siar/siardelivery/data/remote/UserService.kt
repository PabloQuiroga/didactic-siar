package com.siar.siardelivery.data.remote

import com.siar.siardelivery.data.model.ResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
class UserService @Inject constructor(
    private val userApi: UserApi
){
    suspend fun getUser(): Response<ResponseDto>{
        return withContext(Dispatchers.IO){
            userApi.fetchUser()
        }
    }
}
