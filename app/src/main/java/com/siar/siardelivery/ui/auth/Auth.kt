package com.siar.siardelivery.ui.auth

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
object Auth {
    private const val EMAIL_REGEX = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?\$"

    fun checkEmpty(value: String) = value.isNotBlank()

    fun checkEmail(email: String): Boolean {
        return if (checkEmpty(email)){
            email.matches(EMAIL_REGEX.toRegex())
        } else false
    }

    fun checkPsw(pass: String): Boolean {
        return if (checkEmpty(pass)) {
            pass.length > 6
        }else false
    }
}
