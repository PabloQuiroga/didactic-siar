package com.siar.siardelivery.ui.login

import com.siar.siardelivery.ui.account.commons.Auth
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
class LoginTests {
    private val mailCorrect = "asd@asd.com"
    private val passCorrect = "asd1234"


    @Test
    fun login_completeFrom_existUser_returnsSuccess(){
        val isCorrectCredentials = Auth.checkEmail(mailCorrect) && Auth.checkPsw(passCorrect)

        assertTrue(isCorrectCredentials)
    }

    @Test
    fun login_completeForm_notExistUser_returnsFail(){
        val isCorrectCredentials = Auth.checkEmail(mailCorrect) && Auth.checkPsw(passCorrect)

        assertFalse(!isCorrectCredentials)
    }

}
