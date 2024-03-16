package com.siar.siardelivery.data.util

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 16/03/2024
 *****/
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?): Resource<T>(data = data)
    class Error<T>(message: String): Resource<T>(message = message)
    class Loading<T> : Resource<T>()
}
