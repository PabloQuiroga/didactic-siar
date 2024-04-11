package com.siar.siardelivery.ui.register.inputMail

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
data class InputMailState(
    var firstMail: String = "",
    var secondMail: String = "",
    var inputEnabled: Boolean = false,
    var buttonEnabled: Boolean = false,
)
