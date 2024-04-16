package com.siar.siardelivery.ui.register.inputPass

import androidx.lifecycle.ViewModel
import com.siar.siardelivery.domain.model.request.SignupRequest
import com.siar.siardelivery.ui.auth.Auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@HiltViewModel
class PassViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(InputPassState())
    val uiState: StateFlow<InputPassState> = _uiState.asStateFlow()

    private val _navigate = MutableStateFlow(false)
    val navigate: StateFlow<Boolean> = _navigate.asStateFlow()

    fun onFirstPassChanged(pass: String){
        _uiState.update {
            it.copy(
                firstPass = pass,
                inputEnabled = Auth.checkPsw(pass)
            )
        }
    }

    fun onSecondPassChanged(pass: String){
        _uiState.update {
            it.copy(
                secondPass = pass,
                buttonEnabled = it.firstPass.equals(pass)
            )
        }
    }

    fun onClickedNext(){
        SignupRequest.pass = _uiState.value.firstPass
        _navigate.update {
            true
        }
    }
}
