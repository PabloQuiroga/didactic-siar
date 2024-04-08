package com.siar.siardelivery.ui.register

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.siar.siardelivery.R

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 07/03/2024
 *****/
@Composable
fun RegisterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = stringResource(id = R.string.app_name))
    }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}
