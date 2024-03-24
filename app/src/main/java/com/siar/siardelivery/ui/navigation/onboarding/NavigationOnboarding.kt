package com.siar.siardelivery.ui.navigation.onboarding

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.siar.siardelivery.ui.navigation.home.HomeNavScreens
import com.siar.siardelivery.ui.onboarding.login.LoginScreen
import com.siar.siardelivery.ui.onboarding.register.RegisterScreen

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/

fun NavGraphBuilder.addLoginScreen(navController: NavHostController){
    composable(
        OnboardingNavScreens.LoginScreen.route
    ){
        LoginScreen(
            hiltViewModel(),
            onRegisterClick = {
                navigateToRegisterScreen(navController)
            },
            isLoggedIn = {
                navigateToHomeScreen(navController)
            }
        )
    }
}

fun NavGraphBuilder.addRegisterScreen(){
    composable(
        OnboardingNavScreens.RegisterScreen.route
    ){
        RegisterScreen()
    }
}

fun navigateToRegisterScreen(navController: NavHostController){
    navController.navigate(OnboardingNavScreens.RegisterScreen.route)
}
fun navigateToHomeScreen(navController: NavHostController){
    navController.navigate(HomeNavScreens.HomeScreen.route)
}
