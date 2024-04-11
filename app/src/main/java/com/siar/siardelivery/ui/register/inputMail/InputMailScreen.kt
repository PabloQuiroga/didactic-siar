package com.siar.siardelivery.ui.register.inputMail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.siardelivery.R
import com.siar.siardelivery.ui.components.CustomEditText
import com.siar.siardelivery.ui.components.SimpleTopBar

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Suppress("LongParameterList") //TODO
@Composable
fun InputMailScreen(
    viewModel: MailViewModel,
    onClickNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            SimpleTopBar()
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
                        .padding(top = 24.dp, bottom = 24.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary,
                    text = stringResource(id = R.string.mail_screen_title)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    text = stringResource(id = R.string.mail_input_label)
                )

                CustomEditText(
                    data = uiState.firstMail,
                    label = stringResource(id = R.string.edit_lbl_mail),
                    icons = listOf(
                        Icons.Filled.Email
                    ),
                    keyboardType = KeyboardType.Email
                ) {
                    viewModel.onFirstMailChanged(it)
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    text = stringResource(id = R.string.mail_repeat_label)
                )

                CustomEditText(
                    data = uiState.secondMail,
                    label = stringResource(id = R.string.edit_lbl_mail),
                    icons = listOf(
                        Icons.Filled.Email
                    ),
                    enabled = uiState.inputEnabled,
                    keyboardType = KeyboardType.Email
                ) {
                    viewModel.onSecondMailChanged(it)
                }
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                enabled = uiState.buttonEnabled,
                onClick = {
                    onClickNext()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.btn_registration_next)
                )
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun StartRegistrationScreenPreview(){
    InputMailScreen(
        viewModel = MailViewModel(),
        onClickNext = {}
    )
}
