package com.siar.siardelivery.ui.onboarding.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 07/03/2024
 *****/
@Suppress("MagicNumber", "UnusedParameter")
@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(mail: String, pass: String){
        _email.value = mail
        _password.value = pass
        _isLoginEnabled.value = enableLogin(mail, pass)
    }

    private fun enableLogin(email: String, pass: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length > 6

    fun login(mail: String, pass: String){
        // TODO
        _isLoading.value = true
        viewModelScope.launch {
            delay(3000)
            _isLoading.value = false
        }
    }
}
