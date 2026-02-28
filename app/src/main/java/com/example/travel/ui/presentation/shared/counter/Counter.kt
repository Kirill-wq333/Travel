package com.example.travel.ui.presentation.shared.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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

@Preview
@Composable
private fun CounterPrev() {
    Counter(
        quantity = 1,
        onPlus = { }
    ) { }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    quantity: Int,
    onPlus: () -> Unit,
    onMinus: () -> Unit
) {
    Row(
        modifier = modifier
            .background(color = TravelColors.inputBg, shape = RoundedCornerShape(8.dp))
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_minus),
            contentDescription = null,
            tint = if (quantity > 1) Color(0xFF939396) else Color(0xFFB8C1CC),
            modifier = Modifier
                .clickable(
                    enabled = quantity > 1,
                    onClick = onMinus
                )
        )
        Box(modifier = Modifier
            .height(16.dp)
            .width(1.dp)
            .background(TravelColors.inputStroke)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
            contentDescription = null,
            tint = Color(0xFF939396),
            modifier = Modifier
                .clickable(
                    onClick = onPlus
                )
        )
    }
}