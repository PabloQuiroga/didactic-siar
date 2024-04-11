package com.siar.siardelivery.ui.register.personalData

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun PersonalDataScreen(
    viewModel: PersonalDataViewModel,
    onClickNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 24.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.primary,
                    text = stringResource(id = R.string.personal_data_title)
                )

                CustomEditText(
                    data = uiState.fullName,
                    label = stringResource(id = R.string.fullname_input_label),
                    keyboardType = KeyboardType.Text
                ) {
                    viewModel.setFullname(it)
                }
                CustomEditText(
                    data = uiState.phone,
                    label = stringResource(id = R.string.phone_input_label),
                    keyboardType = KeyboardType.Phone
                ) {
                    viewModel.setPhoneNumber(it)
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 8.dp),
                    fontSize = 14.sp,
                    text = stringResource(id = R.string.address_data_subtitle)
                )
                CustomEditText(
                    data = uiState.addressName,
                    label = stringResource(id = R.string.street_name_input_label),
                    keyboardType = KeyboardType.Text
                ) {
                    viewModel.setAddressName(it)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .weight(1f),
                        value = uiState.addressNumber,
                        label = {
                            Text(text = stringResource(id = R.string.street_number_input_label) )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            viewModel.setAddressNumber(it)
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 8.dp),
                        value = uiState.location,
                        label = {
                            Text(text = stringResource(id = R.string.location_input_label) )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = {
                            viewModel.setLocation(it)
                        }
                    )
                }
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                onClick = { onClickNext() }
            ) {
                Text(
                    text = stringResource(id = R.string.btn_registration_ended)
                )
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun PersonalDataPreview(){
    PersonalDataScreen(
        viewModel = PersonalDataViewModel(),
        onClickNext = {}
    )
}
