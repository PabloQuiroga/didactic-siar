package com.siar.siardelivery.ui.account.login.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.siar.siardelivery.ui.account.login.LoginViewState

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/

@Composable
fun LoginContent(
    state: LoginViewState,
    onLoginChanged: (String, String) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
){
    Scaffold(
        content = {
            MainLoginContent(
                paddingValues = it,
                state = state,
                onLoginChanged = { newMail, newPass ->
                    onLoginChanged(newMail, newPass)
                }
            )
        },
        bottomBar = {
            BottomContent(
                enabledLogin = state.enabled,
                onLoginClick = { onLoginClick() },
                onRegisterClick = { onRegisterClick() }
            )
        }
    )
}

@Composable
fun MainLoginContent(
    paddingValues: PaddingValues,
    state: LoginViewState,
    onLoginChanged: (String, String) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(top = 16.dp, start = 12.dp, end = 12.dp)
    ) {
        TitleSection()

        Spacer(modifier = Modifier.padding(24.dp))
        SectionInputs(
            mail = state.mail,
            pass = state.pass,
            onMailChange = { newMail ->
                onLoginChanged(newMail, state.pass)
            },
            onPassChange = { newPass ->
                onLoginChanged(state.mail, newPass)
            }
        )
    }
}

@Composable
fun BottomContent(
    enabledLogin: Boolean,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
){
    Column(
        modifier = Modifier
            .padding(bottom = 32.dp)
    ) {
        Button(
            enabled = enabledLogin,
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
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TitleSection() {
    Text(
        text = stringResource(id = R.string.login_lbl),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp
    )
    Text(
        text = stringResource(id = R.string.login_sub),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        textAlign = TextAlign.Center,
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
    CustomEditText(
        data = mail,
        label = stringResource(id = R.string.edit_lbl_mail),
        icons = listOf(
            Icons.Filled.Email
        ),
        keyboardType = KeyboardType.Email
    ) {
        onMailChange(it)
    }

    Spacer(modifier = Modifier.padding(8.dp))

    CustomEditText(
        data = pass,
        label = stringResource(id = R.string.edit_lbl_pass),
        icons = listOf(
            Icons.Filled.VisibilityOff,
            Icons.Filled.Visibility
        ),
        keyboardType = KeyboardType.Password,
        transformation = PasswordVisualTransformation('\u002A')
    ) {
        onPassChange(it)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginContentPreview(){
        LoginContent(
            state = LoginViewState(),
            onLoginChanged = { _, _ ->
                run {}
            },
            onLoginClick = {},
            onRegisterClick = {}
        )

}
