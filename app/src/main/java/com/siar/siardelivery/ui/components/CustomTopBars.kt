package com.siar.siardelivery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.siar.siardelivery.R

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * File for all custom TopBars
 *****/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopBar(){
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = stringResource(id = R.string.welcome_title),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primaryContainer
            )
        },
        colors = TopAppBarDefaults.topAppBarColors( containerColor = MaterialTheme.colorScheme.primary )
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SimpleTopBarPreview(){
    SimpleTopBar()
}
