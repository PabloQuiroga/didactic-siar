package com.siar.siardelivery.ui.register.inputMail

import androidx.lifecycle.ViewModel
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
class MailViewModel @Inject constructor(): ViewModel(){

    private val _uiState = MutableStateFlow(InputMailState())
    val uiState: StateFlow<InputMailState> = _uiState.asStateFlow()

    fun onFirstMailChanged(mail: String){
        with(_uiState){
            this.update {
                it.copy(
                    firstMail = mail,
                    inputEnabled = Auth.checkEmail(mail)
                )
            }
        }
    }

    fun onSecondMailChanged(mail: String){
        _uiState.update {
            it.copy(
                secondMail = mail,
                buttonEnabled = it.firstMail.equals(mail)
            )
        }
    }
}
