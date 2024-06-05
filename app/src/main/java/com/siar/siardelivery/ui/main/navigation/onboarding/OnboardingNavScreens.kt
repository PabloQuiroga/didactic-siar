package com.siar.siardelivery.ui.main.navigation.onboarding

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
sealed class OnboardingNavScreens(val route: String){
    data object LoginScreen: OnboardingNavScreens("login_screen")

    data object InputMailScreen: OnboardingNavScreens("register_mail_screen")
    data object InputPassScreen: OnboardingNavScreens("register_pass_screen")
    data object InputPersonalDataScreen: OnboardingNavScreens("register_personal_data_screen")
}
