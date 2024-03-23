package com.siar.siardelivery.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.siar.siardelivery.ui.home.navigation.addHomeScreen
import com.siar.siardelivery.ui.onboarding.navigation.OnboardingNavScreens
import com.siar.siardelivery.ui.onboarding.navigation.addLoginScreen
import com.siar.siardelivery.ui.onboarding.navigation.addRegisterScreen

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = OnboardingNavScreens.LoginScreen.route
    ){
        addLoginScreen(navController)
        addRegisterScreen()
        addHomeScreen(navController)
    }
}
