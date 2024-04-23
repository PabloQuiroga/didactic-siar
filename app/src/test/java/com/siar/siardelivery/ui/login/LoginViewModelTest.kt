package com.siar.siardelivery.ui.login

import com.siar.siardelivery.ui.auth.Auth
import com.siar.siardelivery.ui.auth.AuthEvents
import org.junit.Assert.assertEquals
import org.junit.Test

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 */
class LoginViewModelTest{

    @Test
    fun login_emptyEmail_returnsFailEvent(){
        val isCorrectCredentials = if (Auth.checkEmail("mail@mail.com") && Auth.checkPsw("asd1234"))
            AuthEvents.CREDENTIALS_CORRECT else AuthEvents.CREDENTIALS_NOT_CORRECT

        assertEquals(AuthEvents.CREDENTIALS_CORRECT, isCorrectCredentials)
    }

    @Test
    fun login_emptyPassword_returnsFailEvent(){

    }

    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent(){

    }

    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent(){

    }

    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent(){

    }

    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent(){

    }

    @Test
    fun login_completeForm_notExistUser_returnsFailEvent(){

    }

    @Test
    fun login_completeForm_exceptionService_returnsFailEvent(){

    }
}