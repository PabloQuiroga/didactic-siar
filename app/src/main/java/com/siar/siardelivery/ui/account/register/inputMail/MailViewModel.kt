package com.siar.siardelivery.ui.account.register.inputMail

import androidx.lifecycle.ViewModel
import com.siar.siardelivery.domain.model.request.SignupRequest
import com.siar.siardelivery.ui.account.commons.Auth
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

    private val _navigate = MutableStateFlow(false)
    val navigate: StateFlow<Boolean> = _navigate.asStateFlow()

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

    fun onClickedNext(){
        SignupRequest.mail = _uiState.value.firstMail
        _navigate.update {
            true
        }
    }
}
