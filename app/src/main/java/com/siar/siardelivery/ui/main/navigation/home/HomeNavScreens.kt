package com.siar.siardelivery.ui.main.navigation.home

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
sealed class HomeNavScreens(val route: String){
    data object HomeScreen: HomeNavScreens("home_screen")
}
