package com.siar.siardelivery.ui.onboarding.utils

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.siar.siardelivery.ui.onboarding.login.LoginScreen

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
        composable(
            OnboardingScreens.LoginScreen.route
        ){
            LoginScreen()
        }

    }
}