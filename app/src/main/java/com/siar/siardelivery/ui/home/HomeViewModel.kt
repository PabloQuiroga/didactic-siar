package com.siar.siardelivery.ui.home

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
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(HomeViewState())
    val uiState: StateFlow<HomeViewState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(name = "pablo")
        }
    }
}
