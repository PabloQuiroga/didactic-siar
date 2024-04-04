package com.siar.siardelivery.ui.onboarding.register.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siar.siardelivery.R
import com.siar.siardelivery.ui.components.CustomEditText
import com.siar.siardelivery.ui.theme.DeliveryTheme

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDocView(
    mail: String = "",
    enabled: Boolean = false,
    onMailChange: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.welcome_signup_title),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                },
                colors = topAppBarColors( containerColor = MaterialTheme.colorScheme.primary )
            )

        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.mail_description)
                )

                CustomEditText(
                    data = mail,
                    label = stringResource(id = R.string.edit_lbl_mail),
                    icons = listOf(
                        Icons.Filled.Email
                    )
                ) {
                    onMailChange(it)
                }
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                enabled = enabled,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(id = R.string.next)
                )
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun InputPreview() {
    DeliveryTheme {
        InputDocView(){}
    }
}
