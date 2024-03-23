package com.siar.siardelivery.ui.onboarding.navigation

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
sealed class OnboardingNavScreens(val route: String){
    data object LoginScreen: OnboardingNavScreens("login_screen")
    data object RegisterScreen: OnboardingNavScreens("register_screen")
}
