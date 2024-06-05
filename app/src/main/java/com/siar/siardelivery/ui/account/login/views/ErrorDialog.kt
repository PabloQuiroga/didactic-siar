package com.siar.siardelivery.ui.account.login.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.siardelivery.R

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun ErrorDialog(
    title: String? = null,
    msg: String,
) {
    AlertDialog(
        title = {
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                text = title ?: stringResource(id = R.string.login_error_title_default),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                modifier = Modifier
                    .padding(0.dp),
                text = msg,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic
            )
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.retry_lbl))
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ErrorViewPreview() {
    ErrorDialog(
        title = stringResource(id = R.string.login_error_title_default),
        msg = "Hubo un error en el envio de datos al servidor"
    )
}
