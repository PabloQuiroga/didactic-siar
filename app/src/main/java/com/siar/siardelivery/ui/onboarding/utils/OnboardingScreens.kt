package com.siar.siardelivery.ui.onboarding.utils

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
sealed class OnboardingScreens(val route: String){
    object LoginScreen: OnboardingScreens("login_screen")
}
