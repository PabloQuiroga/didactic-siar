package com.siar.siardelivery.ui.onboarding.login

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
data class LoginViewState(
    var mail: String = "",
    var pass: String = "",
    var enabled: Boolean = false,
    var isLoggedIn: Boolean = false
)
