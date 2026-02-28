package com.example.travel.ui.presentation.shared.toggle

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel.ui.theme.TravelColors

@Preview
@Composable
private fun TogglePrev() {
    var isSelected by remember { mutableStateOf(false) }

    Toggle(isSelected = isSelected) { isSelected = !isSelected }
}

@Composable
fun Toggle(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backColor = if (isSelected) TravelColors.accent else TravelColors.inputStroke

    val colorBack by animateColorAsState(
        targetValue = backColor,
        animationSpec = tween(700)
    )

    val paddingLeft by animateDpAsState(
        targetValue = if (isSelected) 22.dp else 2.dp,
        animationSpec = tween(700)
    )

    val paddingRight by animateDpAsState(
        targetValue = if (isSelected) 2.dp else 22.dp,
        animationSpec = tween(700)
    )

    Box(
        modifier = modifier
            .background(color = colorBack, shape = CircleShape)
            .clickable(onClick = onClick)
    ){
        Box(
            modifier = Modifier
                .padding(top = 2.dp, bottom = 2.dp, start = paddingLeft, end = paddingRight)
                .size(24.dp)
                .background(color = Color.White, shape = CircleShape)
        )
    }
}