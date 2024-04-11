package com.siar.siardelivery.ui.auth

import android.util.Patterns

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
object Auth {
    fun checkEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun checkPsw(pass: String): Boolean {
        return pass.length > 6
    }
}
