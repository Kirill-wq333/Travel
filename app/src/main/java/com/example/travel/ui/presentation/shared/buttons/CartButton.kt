package com.example.travel.ui.presentation.shared.buttons

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.example.travel.R
import com.example.travel.ui.theme.TravelColors
import com.example.travel.ui.theme.TravelTypography

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
    price: Int,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = TravelColors.accent, shape = RoundedCornerShape(5.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_cart),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "Оплатить",
                color = Color.White,
                style = TravelTypography.titleSemiBold17
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = price.toString(),
                color = Color.White,
                style = TravelTypography.titleSemiBold17
            )
            Text(
                text = "₽",
                color = Color.White,
                style = TravelTypography.titleSemiBold17
            )
        }
    }
}