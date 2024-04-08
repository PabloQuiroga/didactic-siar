package com.siar.siardelivery.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.siar.siardelivery.ui.components.SimpleTopBar

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun HomeScreen(
    viewmodel: HomeViewModel
) {
    val uiState by viewmodel.uiState.collectAsState()

    Scaffold(
        topBar = {
            SimpleTopBar()
        },
        content = {
            ContentHome(paddingValues = it)
        }
    )
}

@Composable
fun ContentHome(
    paddingValues: PaddingValues
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.TopCenter
    ){
        Text(text = "homeScreen")
    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        hiltViewModel()
    )
}
