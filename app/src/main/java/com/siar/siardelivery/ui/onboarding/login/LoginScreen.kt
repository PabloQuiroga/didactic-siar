package com.siar.siardelivery.ui.onboarding.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.siar.siardelivery.R

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *
 * Last update: 06/03/2024
 *****/
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onRegisterClick: () -> Unit,
) {
    val mail by loginViewModel.email.observeAsState(initial = "")
    val pass by loginViewModel.password.observeAsState(initial = "")
    val loginEnabled by loginViewModel.isLoginEnabled.observeAsState(initial = false)
    val isLoading by loginViewModel.isLoading.observeAsState(initial = false)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (
            colContent,
            actionSection,
            progressBar,
        ) = createRefs()

        if (!isLoading) {
            Column(
                modifier = Modifier
                    .constrainAs(colContent) {
                        top.linkTo(parent.top)
                    }
                    .padding(top = 16.dp)
            ) {
                TitleSection()

                SectionInputs(
                    mail = mail,
                    pass = pass,
                    onMailChange = {
                        loginViewModel.onLoginChanged(mail = it, pass = pass)
                    },
                    onPassChange = {
                        loginViewModel.onLoginChanged(mail = mail, pass = it)
                    }
                )
            }

            Column(
                modifier = Modifier
                    .constrainAs(actionSection) {
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                ActionSection(
                    enable = loginEnabled,
                    onLoginClick = {
                        loginViewModel.login(mail, pass)
                    },
                    onRegisterClick = {
                        onRegisterClick()
                    }
                )
            }

        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .constrainAs(progressBar) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun ActionSection(
    enable: Boolean,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Button(
        enabled = enable,
        onClick = {
            onLoginClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login_btn_lbl),
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )
    }

    Text(
        text = stringResource(id = R.string.login_redirect_signin_lbl),
        modifier = Modifier
            .clickable {
                onRegisterClick()
            }
            .fillMaxWidth()
            .padding(bottom = 16.dp, top = 8.dp),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TitleSection() {
    Text(
        text = stringResource(id = R.string.login_lbl),
        modifier = Modifier
            .padding(top = 24.dp, start = 32.dp),
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp
    )
    Text(
        text = stringResource(id = R.string.login_sub),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 32.dp),
        textAlign = TextAlign.Start,
        fontSize = 14.sp
    )
}

@Composable
fun SectionInputs(
    mail: String,
    pass: String,
    onMailChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = mail,
        onValueChange = { onMailChange(it) },
        label = { Text(text = stringResource(id = R.string.edit_lbl_mail)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(id = R.color.orange_400),
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background
        ),
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Email, contentDescription = "email icon")
        },
    )
    OutlinedTextField(
        value = pass,
        onValueChange = { onPassChange(it) },
        label = { Text(text = stringResource(id = R.string.edit_lbl_pass)) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(id = R.color.orange_400),
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background
        ),
        trailingIcon = {
            val image = if (passwordVisibility)
                Icons.Filled.VisibilityOff else Icons.Filled.Visibility

            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "show password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation('\u002A')
        }
    )
}
