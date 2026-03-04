package com.example.travel.ui.presentation.shared.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel.ui.theme.TravelColors
import com.example.travel.ui.theme.TravelTypography
import com.example.travel.ui.theme.spacers.TravelSpacers

@Preview
@Composable
private fun TravelBtnAndChipPrev() {
    var isSelected by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()){
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            bigBtn = true,
            activeBtn = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            bigBtn = true,
            unActiveBtn = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            bigBtn = true,
            notBack = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            bigBtn = true,
            onClick = {},
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            activeBtn = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            unActiveBtn = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
            notBack = true
        )
        TravelBtn(
            textBtn = "dfhdhfdh",
            onClick = {},
        )
        TravelChipBtn(
            textChip = "fghn",
            onClick = { isSelected = !isSelected },
            isSelected = isSelected
        )
    }
}

@Composable
fun TravelBtn(
    modifier: Modifier = Modifier,
    textBtn: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    bigBtn: Boolean = false,
    notBack: Boolean = false,
    activeBtn: Boolean = false,
    unActiveBtn: Boolean = false
) {
    val modifierBtn = if (bigBtn) modifier.fillMaxWidth() else modifier
    val verticalPadding = if (bigBtn) TravelSpacers.spacer16 else 10.dp
    val horizontalPadding = if (bigBtn) 0.dp else 15.dp
    val background = when{
        activeBtn -> TravelColors.accent
        unActiveBtn -> TravelColors.accentInactive
        notBack -> Color.White
        else -> TravelColors.inputBg
    }

    val color = when{
        activeBtn -> TravelColors.white
        unActiveBtn -> TravelColors.white
        notBack -> TravelColors.accent
        else -> TravelColors.black
    }

    val backColor by animateColorAsState(
        targetValue = background,
        animationSpec = tween(700)
    )
    val textColor by animateColorAsState(
        targetValue = color,
        animationSpec = tween(700)
    )
    
    ContentButton(
        modifier = modifierBtn
            .border(width = 1.dp, color = if (notBack) TravelColors.accent else Color.Unspecified, shape = RoundedCornerShape(5.dp)),
        modifierText = Modifier
            .padding(
                vertical = verticalPadding,
                horizontal = horizontalPadding
            ),
        textBtn = textBtn,
        onClick = onClick,
        enabled = enabled,
        backColor = backColor,
        colorText = textColor,
        styleText = if (bigBtn) TravelTypography.titleSemiBold17 else TravelTypography.captionSemiBold14
    )
}

@Composable
fun TravelChipBtn(
    modifier: Modifier = Modifier,
    textChip: String,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    val backColor = if (isSelected) TravelColors.accent else TravelColors.inputBg
    val textColor = if (isSelected) Color.White else TravelColors.description

    val background by animateColorAsState(
        targetValue = backColor,
        animationSpec = tween(500)
    )
    val textC by animateColorAsState(
        targetValue = textColor,
        animationSpec = tween(500)
    )

    ContentButton(
        modifier = modifier,
        modifierText = Modifier
            .padding(vertical = 14.dp, horizontal = 20.dp),
        textBtn = textChip,
        onClick = onClick,
        backColor = background,
        colorText = textC,
        styleText = TravelTypography.textMedium15
    )
}


@Composable
fun ContentButton(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    textBtn: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    backColor: Color,
    colorText: Color,
    styleText: TextStyle
) {

    Box(
        modifier = modifier
            .clickable(enabled = enabled, onClick = onClick)
            .background(color = backColor, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = textBtn,
            color = colorText,
            style = styleText,
            modifier = modifierText
        )
    }
}