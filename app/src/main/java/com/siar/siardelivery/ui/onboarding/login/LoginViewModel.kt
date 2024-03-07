package com.siar.siardelivery.ui.onboarding.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 07/03/2024
 *****/
@HiltViewModel
class LoginViewModel @Inject constructor(

): ViewModel() {

    fun login(mail: String, pass: String){
        // TODO
        Log.e("LOGINVIEWMODEL", "$mail $pass")
    }
}
