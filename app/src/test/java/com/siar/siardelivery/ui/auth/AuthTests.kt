package com.siar.siardelivery.ui.auth

import com.siar.siardelivery.ui.account.commons.Auth
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 */
class AuthTests{

    private val mailCorrect = "asd@asd.com"
    private val passCorrect = "asd1234"
    private val mailIncorrect = "asd.com"
    private val passIncorrect = "asd123"

    @Test
    fun check_mailCorrect(){
        assertTrue(Auth.checkEmail(mailCorrect))
    }

    @Test
    fun check_isNotEmptyMail(){
        assertTrue(Auth.checkEmpty(mailCorrect))
    }

    @Test
    fun check_passCorrect(){
        assertTrue(Auth.checkPsw(passCorrect))
    }

    @Test
    fun check_isNotEmptyPass(){
        assertTrue(Auth.checkEmpty(passCorrect))
    }

    @Test
    fun login_completeForm_invalidEmail_returnsFail(){
        val isCorrectCredentials = Auth.checkEmail(mailIncorrect) && Auth.checkPsw(passCorrect)

        Assert.assertFalse(isCorrectCredentials)
    }

    @Test
    fun login_emptyEmail_returnsFail(){
        val isCorrectCredentials = Auth.checkEmail("") && Auth.checkPsw(passCorrect)

        Assert.assertFalse(isCorrectCredentials)
    }

    @Test
    fun login_emptyPassword_returnsFail(){
        val isCorrectCredentials = Auth.checkEmail(mailCorrect) && Auth.checkPsw("")

        Assert.assertFalse(isCorrectCredentials)
    }

    @Test
    fun login_completeForm_invalidPassword_returnsFail(){
        val isCorrectCredentials = Auth.checkEmail(mailCorrect) && Auth.checkPsw(passIncorrect)

        Assert.assertFalse(isCorrectCredentials)
    }

}
