package com.siar.siardelivery.domain

import kotlinx.coroutines.delay
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 11/03/2024
 *****/
class LoginUseCase @Inject constructor() {

    suspend operator fun invoke(mail: String, pass: String): Boolean{
        delay(3000)
        return doLogin(mail, pass) // TODO
    }

    /* TODO
      to test
      replace with repository
     */
    private fun doLogin(mail: String, pass: String): Boolean{
        return mail.isBlank() && pass.isBlank()
    }
}