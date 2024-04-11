package com.siar.siardelivery.ui.register.personalData

import androidx.lifecycle.ViewModel
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
class PersonalDataViewModel @Inject constructor(): ViewModel(){

    private val _uiState = MutableStateFlow(PersonalDataState())
    val uiState: StateFlow<PersonalDataState> = _uiState.asStateFlow()

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
}
