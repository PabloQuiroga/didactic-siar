package com.siar.siardelivery.ui.navigation.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.siar.siardelivery.ui.home.HomeScreen

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
fun NavGraphBuilder.addHomeScreen(){
    composable(
        HomeNavScreens.HomeScreen.route
    ){
        HomeScreen(hiltViewModel())
    }
}
