package com.siar.siardelivery.ui.navigation.onboarding

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.siar.siardelivery.ui.navigation.home.HomeNavScreens
import com.siar.siardelivery.ui.login.LoginScreen
import com.siar.siardelivery.ui.register.inputMail.InputMailScreen

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
                navigateToRegisterMailScreen(navController)
            },
            isLoggedIn = {
                navigateToHomeScreen(navController)
            }
        )
    }
}

fun NavGraphBuilder.addRegisterMailScreen(navController: NavHostController){
    composable(
        OnboardingNavScreens.InputMailScreen.route
    ){
        InputMailScreen(
            hiltViewModel(),
            onClickNext = {
                navigateToRegisterPassScreen()
            }
        )
    }
}


fun navigateToHomeScreen(navController: NavHostController){
    navController.navigate(HomeNavScreens.HomeScreen.route)
}
fun navigateToRegisterMailScreen(navController: NavHostController){
    navController.navigate(OnboardingNavScreens.InputMailScreen.route)
}
fun navigateToRegisterPassScreen(){
    //navController.navigate()
}
fun navigateToRegisterPersonalDataScreen(){
    //navController.navigate()
}
