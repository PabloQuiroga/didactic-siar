package com.siar.siardelivery.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * TODO only for demo now
 *
 * Last update: 11/03/2024
 *****/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewmodel: HomeViewModel
) {
    val uiState by viewmodel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = uiState.name ?: "Bienvenido") },

            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ){
            Text(text = "homeScreen")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        hiltViewModel()
    )
}
