package com.siar.siardelivery.ui.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siar.siardelivery.ui.onboarding.login.LoginScreen
import com.siar.siardelivery.ui.onboarding.login.LoginViewModel
import com.siar.siardelivery.ui.onboarding.register.RegisterScreen

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
@Composable
fun OnboardingNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingScreens.LoginScreen.route
    ){
        addLoginScreen(navController)
        addRegisterScreen()
    }
}


fun NavGraphBuilder.addLoginScreen(navController: NavHostController){
    composable(
        OnboardingScreens.LoginScreen.route
    ){
        val viewmodel: LoginViewModel = hiltViewModel()
        LoginScreen(
            viewmodel,
            onRegisterClick = {
                navigateToRegisterScreen(navController)
            }
        )
    }
}

fun NavGraphBuilder.addRegisterScreen(){
    composable(
        OnboardingScreens.RegisterScreen.route
    ){
        RegisterScreen()
    }
}

fun navigateToRegisterScreen(navController: NavHostController){
    navController.navigate(OnboardingScreens.RegisterScreen.route)
}
