package com.example.travel.ui.presentation.shared.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.ui.theme.TravelColors

@Preview
@Composable
private fun LogInBtnPrev() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LogInBtn(
            icon = R.drawable.ic_vk_logo
        )
        LogInBtn(
            icon = R.drawable.ic_yandex_logo
        )
    }
}

@Composable
fun LogInBtn(
    modifier: Modifier = Modifier,
    icon: Int
) {
    Box(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = TravelColors.inputStroke,
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(19.dp)
        )
    }
}