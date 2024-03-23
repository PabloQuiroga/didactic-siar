package com.siar.siardelivery.ui.onboarding.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.siardelivery.data.util.Resource
import com.siar.siardelivery.domain.LoginUseCase
import com.siar.siardelivery.domain.model.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 07/03/2024
 *****/
@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase
    ): ViewModel() {

    private val _uiState = MutableStateFlow(LoginViewState())
    val uiState: StateFlow<LoginViewState> = _uiState.asStateFlow()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(mail: String, pass: String){
        val request = LoginRequest(mail, pass) // maybe can be better

        changeLoadingState(true)
        viewModelScope.launch {
            when (loginUseCase(request)){
                is Resource.Success -> {
                    changeLoadingState(false)
                    // everything ok and have user data
                    _uiState.update {
                        it.copy(isLoggedIn = true)
                    }
                }
                is Resource.Error -> {
                    changeLoadingState(false)
                    // have some error with message
                }
                is Resource.Loading -> {}
            }
        }
    }

    fun onLoginChanged(mail: String, pass: String){
        _uiState.update {
            it.copy(
                mail = mail,
                pass = pass,
                enabled = enableLogin(mail, pass)
            )
        }
    }

    private fun enableLogin(email: String, pass: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && pass.length > 6

    private fun changeLoadingState(state: Boolean) {
        _isLoading.value = state
    }
}
