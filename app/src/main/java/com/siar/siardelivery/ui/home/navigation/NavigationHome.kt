package com.siar.siardelivery.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.siar.siardelivery.ui.home.HomeScreen
import com.siar.siardelivery.ui.onboarding.navigation.OnboardingNavScreens

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
fun NavGraphBuilder.addHomeScreen(navController: NavHostController){
    composable(
        HomeNavScreens.HomeScreen.route
    ){
        HomeScreen{
            navController.navigate(OnboardingNavScreens.LoginScreen.route)
        }
    }
}
