package com.siar.siardelivery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.siar.siardelivery.ui.navigation.home.addHomeScreen
import com.siar.siardelivery.ui.navigation.onboarding.OnboardingNavScreens
import com.siar.siardelivery.ui.navigation.onboarding.addLoginScreen
import com.siar.siardelivery.ui.navigation.onboarding.addRegisterMailScreen
import com.siar.siardelivery.ui.navigation.onboarding.addRegisterPassScreen
import com.siar.siardelivery.ui.navigation.onboarding.addRegisterPersonalDataScreen

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
        addRegisterMailScreen(navController)
        addRegisterPassScreen(navController)
        addRegisterPersonalDataScreen(navController)

        addHomeScreen()
    }
}
