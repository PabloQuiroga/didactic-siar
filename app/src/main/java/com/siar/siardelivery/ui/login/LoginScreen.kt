package com.siar.siardelivery.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.siar.siardelivery.ui.login.views.LoaderView
import com.siar.siardelivery.ui.login.views.LoginContent

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 21/03/2024
 *****/
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onRegisterClick: () -> Unit,
    isLoggedIn: () -> Unit
) {
    val uiState by loginViewModel.uiState.collectAsState()
    val isLoading by loginViewModel.isLoading.observeAsState(initial = false)

    LaunchedEffect(key1 = uiState.isLoggedIn) {
        if (uiState.isLoggedIn){
            isLoggedIn()
        }
    }

    if (isLoading) {
        LoaderView()
    } else {
        LoginContent(
            uiState,
            onLoginChanged = { newEmail, newPass ->
                loginViewModel.onLoginChanged(newEmail, newPass)
            },
            onLoginClick = {
                loginViewModel.login(uiState.mail, uiState.pass)
            },
            onRegisterClick = {
                onRegisterClick()
            }
        )
    }
}
