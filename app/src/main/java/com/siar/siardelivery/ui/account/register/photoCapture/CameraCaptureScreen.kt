package com.siar.siardelivery.ui.account.register.photoCapture

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*****
 * Project: Siar Delivery
 * Created by: Pablo Daniel Quiroga
 *****/
@Composable
fun CameraCaptureScreen() {
    OvalShape()
}

@Composable
fun OvalShape() {
    val color = MaterialTheme.colorScheme.primary
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radiusX = size.width / 2
        val radiusY = size.height / 2

        drawOval(
            color = color,
            topLeft = Offset(centerX - radiusX, centerY - radiusY),
            size = Size(radiusX * 2, radiusY * 2),
            style = Stroke(width = 4.dp.toPx())
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CameraCapturePreview(){
    CameraCaptureScreen()
}
