package com.siar.siardelivery.ui.account.register.inputPass

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
data class InputPassState(
    var firstPass: String = "",
    var secondPass: String = "",
    var inputEnabled: Boolean = false,
    var buttonEnabled: Boolean = false,
)
