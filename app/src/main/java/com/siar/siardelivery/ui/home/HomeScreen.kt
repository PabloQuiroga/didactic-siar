package com.siar.siardelivery.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * TODO only for demo now
 *
 * Last update: 11/03/2024
 *****/
@Composable
fun HomeScreen(
    onLogout: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Text(text = "homeScreen")
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = { onLogout() }) {
                Text(text = "volver")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen {}
}
