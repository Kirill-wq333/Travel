package com.example.travel.ui.presentation.shared.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.travel.R
import com.example.travel.ui.presentation.shared.buttons.TravelBtn
import com.example.travel.ui.theme.TravelTypography

@Preview
@Composable
private fun BigTravelCardPrev() {
    var selected by remember { mutableStateOf(true) }

    BigTravelCard(
        photoHotel = "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/cb8cc062-2a73-45a1-b6af-0551110ac473/1920x",
        nameHotel = "Отель гран-будапешт",
        price = 500,
        enterSelected = selected
    ) { selected = !selected }
}

@Composable
fun BigTravelCard(
    modifier: Modifier = Modifier,
    photoHotel: String,
    nameHotel: String,
    price: Int,
    enterSelected: Boolean,
    enterHotel: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(15.dp))
            .border(width = 1.dp, color = Color(0xFFE5E5E5), shape = RoundedCornerShape(15.dp)),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
        ) {
            AsyncImage(
                model = photoHotel,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(46.dp)
        ) {
            Text(
                text = nameHotel,
                color = Color.Black,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Text(
                        text = "от",
                        color = Color.Black,
                        style = TravelTypography.titleSemiBold17
                    )
                    Text(
                        text = "$price ₽",
                        color = Color.Black,
                        style = TravelTypography.titleSemiBold17
                    )
                }
                TravelBtn(
                    textBtn = if (enterSelected) "Выбрать" else "Отменить",
                    onClick = enterHotel,
                    activeBtn = enterSelected,
                    notBack = !enterSelected
                )
            }
        }
    }
}