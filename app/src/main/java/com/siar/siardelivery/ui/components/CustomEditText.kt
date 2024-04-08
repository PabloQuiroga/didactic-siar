package com.siar.siardelivery.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siar.siardelivery.R
import com.siar.siardelivery.ui.theme.DeliveryTheme

/*****
 * Project: DemoNavigationCompose
 * Created by: Pablo Daniel Quiroga
 *
 * File for all custom EditText
 *****/
@Composable
fun CustomEditText(
    data: String,
    label: String? = null,
    icons: List<ImageVector>? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    transformation: VisualTransformation = VisualTransformation.None,
    onDataChange: (String) -> Unit
) {
    var transformed by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = data,
        onValueChange = {
            onDataChange(it)
        },
        label = {
            Text(text = label ?: "" )
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = colorResource(id = R.color.orange_400),
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background
        ),
        trailingIcon = {
            icons?.apply {
                val image = if (!transformed)
                    icons[0] else icons[1]

                IconButton(
                    onClick = {
                        //TODO maybe this can be made as abstract for change function
                        if (icons.size > 1){ transformed = !transformed }
                    },
                    content = {
                        Icon(imageVector = image, contentDescription = "")
                    }
                )
            }
        },
        visualTransformation = if (!transformed) transformation else VisualTransformation.None
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomEdtPreview(){
    DeliveryTheme {
        CustomEditText(
            data = "pepe",
            label = "label",
            icons = listOf( Icons.Filled.AcUnit )
        ) {}
    }
}
