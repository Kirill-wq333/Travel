package com.example.travel.ui.presentation.shared.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.ui.theme.TravelTypography

@Preview
@Composable
private fun SnackBarPrev() {
    SnackBar(message = "Привет страна, как дела? hdgskjghdkjewgdfgdhd"){}
}

@Composable
fun SnackBar(
    modifier: Modifier = Modifier,
    message: String,
    onClose: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_dismiss),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .clickable(onClick = onClose)
        )
        Text(
            text = message,
            color = Color.Black,
            style = TravelTypography.titleExtraBold20,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(
                    vertical = 46.dp,
                    horizontal = 20.dp
                )
        )
    }
}