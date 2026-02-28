package com.example.travel.ui.presentation.shared.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import com.example.travel.ui.theme.TravelColors
import com.example.travel.ui.theme.TravelTypography

@Preview
@Composable
private fun SelectionPrev() {
    Selection(
        onCLick = {},
        text = "Пол",
        colorText = Color(0xFF939396)
    )
}

@Composable
fun Selection(
    modifier: Modifier = Modifier,
    onCLick: () -> Unit,
    text: String,
    colorText: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TravelColors.inputBg, shape = RoundedCornerShape(5.dp))
            .border(
                width = 1.dp,
                color = TravelColors.inputStroke,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(14.dp)
            .clickable(onClick = onCLick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = text,
            color = colorText,
            style = TravelTypography.headlineRegular16
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down),
            contentDescription = null,
            tint = Color.Unspecified
        )
    }
}