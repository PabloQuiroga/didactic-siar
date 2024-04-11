package com.siar.siardelivery.ui.login.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun LoaderView(
    message: String? = null,
) {
    LoadingBox(
        isLoading = true,
        loadingText = message ?: ""
    )
}

@Composable
fun LoadingBox(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    loadingText: String,
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        if (isLoading) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.7f),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(60.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        strokeWidth = 20.dp
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = loadingText,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoaderPreview(){
    LoaderView("mensaje de carga")
}
