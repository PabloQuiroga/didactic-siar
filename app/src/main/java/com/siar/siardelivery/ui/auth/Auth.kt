package com.siar.siardelivery.ui.auth

import android.util.Patterns

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
object Auth {
    private const val EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    fun checkEmail(email: String): Boolean {
        return email.matches(EMAIL_REGEX.toRegex())
    }

    fun checkPsw(pass: String): Boolean {
        return pass.length > 6
    }
}
