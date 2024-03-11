package com.siar.siardelivery.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.siar.siardelivery.ui.onboarding.navigation.OnboardingNavigation
import com.siar.siardelivery.ui.theme.DeliveryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                !viewmodel.isReady.value
            }
        }
        setContent {
            DeliveryTheme{
                OnboardingNavigation()
            }
        }
    }
}
