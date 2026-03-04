package com.example.travel.ui.presentation.shared.buttons.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.travel.ui.theme.TravelColors

@Composable
fun BigBtn(
    modifier: Modifier = Modifier,
    icon: Int
) {
    IconBtn(
        icon = icon,
        padding = 14.dp
    )
}


@Composable
fun IconBtn(
    modifier: Modifier = Modifier,
    icon: Int,
    padding: Dp = 6.dp
) {
    Box(
        modifier = modifier
            .background(color = TravelColors.inputBg, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            modifier = Modifier
                .padding(padding)
        )
    }
}