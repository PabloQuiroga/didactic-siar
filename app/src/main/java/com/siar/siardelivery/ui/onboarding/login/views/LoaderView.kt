package com.siar.siardelivery.ui.onboarding.login.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun LoaderView(
    message: String? = null,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
            message?.apply {
                Text(
                    modifier = Modifier
                        .padding(top = 32.dp),
                    text = this
                )
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun LoaderPreview(){
    LoaderView("mensaje de carga")
}
