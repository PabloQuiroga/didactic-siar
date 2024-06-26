package com.siar.siardelivery.ui.account.register.inputPass

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.siardelivery.R
import com.siar.siardelivery.ui.components.CustomEditText

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun PassRegistrationScreen(
    viewModel: PassViewModel,
    goToNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val navigate by viewModel.navigate.collectAsState()

    LaunchedEffect(key1 = navigate) {
        if (navigate){
            goToNext()
        }
    }

    Scaffold(
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
                    text = stringResource(id = R.string.pass_screen_title)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    text = stringResource(id = R.string.pass_input_label)
                )

                CustomEditText(
                    data = uiState.firstPass,
                    label = stringResource(id = R.string.edit_lbl_pass),
                    icons = listOf(
                        Icons.Filled.VisibilityOff,
                        Icons.Filled.Visibility
                    ),
                    keyboardType = KeyboardType.Password,
                    transformation = PasswordVisualTransformation('\u002A')
                ) {
                    viewModel.onFirstPassChanged(it)
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    text = stringResource(id = R.string.pass_repeat_label)
                )

                CustomEditText(
                    data = uiState.secondPass,
                    label = stringResource(id = R.string.edit_lbl_pass),
                    icons = listOf(
                        Icons.Filled.VisibilityOff,
                        Icons.Filled.Visibility
                    ),
                    enabled = uiState.inputEnabled,
                    keyboardType = KeyboardType.Password,
                    transformation = PasswordVisualTransformation('\u002A')
                ) {
                    viewModel.onSecondPassChanged(it)
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
                    viewModel.onClickedNext()
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
fun PassRegistrationScreenPreview(){
    PassRegistrationScreen(
        viewModel = PassViewModel(),
        goToNext = {}
    )
}
