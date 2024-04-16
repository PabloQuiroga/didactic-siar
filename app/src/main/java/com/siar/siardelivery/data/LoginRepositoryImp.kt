package com.siar.siardelivery.data

import com.siar.siardelivery.data.remote.UserService
import com.siar.siardelivery.data.util.Resource
import com.siar.siardelivery.domain.model.request.LoginRequest
import com.siar.siardelivery.domain.model.response.Response
import com.siar.siardelivery.domain.repository.LoginRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 13/03/2024
 *****/
@Suppress("TooGenericExceptionCaught", "SwallowedException")
class LoginRepositoryImp @Inject constructor(
    private val service: UserService
): LoginRepository {

    override suspend fun doLogin(request: LoginRequest): Resource<Response> {

        return try {
            val response = service.getUser()

            if (response.isSuccessful) {
                if(response.body() != null){
                    Resource.Success(data = response.body()!!.toDomain())
                } else {
                    Resource.Error(message = "response is empty")
                }
            } else {
                Resource.Error(
                    message = response.errorBody().toString()
                )
            }

        } catch (e: HttpException) {
            Resource.Error(message = e.message ?: "Something went wrong")
        } catch (e: IOException) {
            Resource.Error("Please check your network connection")
        } catch (e: Exception) {
            Resource.Error(message = "Something went wrong")
        }

    }
}
