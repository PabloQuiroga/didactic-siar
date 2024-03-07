package com.siar.siardelivery.ui.onboarding.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var mail by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (
            colContent,
            btnLogin,
            lblSignin,
        ) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(colContent) {
                    top.linkTo(parent.top)
                }
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login_lbl),
                modifier = Modifier
                    .padding(top = 24.dp, start = 32.dp),
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp
            )
            Text(
                text = stringResource(id = R.string.login_sub),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, start = 32.dp),
                textAlign = TextAlign.Start,
                fontSize = 14.sp
            )

            SectionInputs(
                mail = mail,
                pass = pass,
                onMailChange = {
                    mail = it
                },
                onPassChange = {
                    pass = it
                }
            )
        }

        Button(
            onClick = {
                      onLoginClick(mail, pass)
                      },
            modifier = Modifier
                .constrainAs(btnLogin) {
                    bottom.linkTo(lblSignin.top)
                }
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
                .constrainAs(lblSignin) {
                    bottom.linkTo(parent.bottom)
                }
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

}

@Composable
fun SectionInputs(
    mail: String,
    pass: String,
    onMailChange: (String) -> Unit,
    onPassChange: (String) -> Unit
) {
    OutlinedTextField(
        value = mail,
        onValueChange = { onMailChange(it) },
        label = { Text(text = stringResource(id = R.string.edit_lbl_mail))},
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp),
    )
    OutlinedTextField(
        value = pass,
        onValueChange = { onPassChange(it) },
        label = { Text(text = stringResource(id = R.string.edit_lbl_pass))},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
    )
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginClick = { _, _ ->
            /* TODO */
        },
        onRegisterClick = {}
    )
}
