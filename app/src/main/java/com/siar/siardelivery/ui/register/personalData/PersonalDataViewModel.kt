package com.siar.siardelivery.ui.register.personalData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.siardelivery.domain.SignupUseCase
import com.siar.siardelivery.domain.model.request.SignupRequest
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
 *****/
@HiltViewModel
class PersonalDataViewModel @Inject constructor(
    val signupUseCase: SignupUseCase
): ViewModel(){

    private val _uiState = MutableStateFlow(PersonalDataState())
    val uiState: StateFlow<PersonalDataState> = _uiState.asStateFlow()

    private val _navigate = MutableStateFlow(false)
    val navigate: StateFlow<Boolean> = _navigate.asStateFlow()

    fun setFullname(name: String){
        _uiState.update {
            it.copy(
                fullName = name
            )
        }
    }

    fun setPhoneNumber(phone: String){
        _uiState.update {
            it.copy(
                phone = phone
            )
        }
    }

    fun setAddressName(address: String){
        _uiState.update {
            it.copy(
                addressName = address
            )
        }
    }

    fun setAddressNumber(address: String){
        _uiState.update {
            it.copy(
                addressNumber = address
            )
        }
    }

    fun setLocation(location: String){
        _uiState.update {
            it.copy(
                location = location
            )
        }
    }

    fun onClickedNext(){

        with(SignupRequest){
            this.fullname = _uiState.value.fullName
            this.phone = _uiState.value.phone
            this.address = _uiState.value.addressName + _uiState.value.addressNumber
            this.location = _uiState.value.location
        }

        viewModelScope.launch {
            signupUseCase(SignupRequest) // TODO handle here UiStates and navigation

            _navigate.update {
                true
            }
        }


    }
}
