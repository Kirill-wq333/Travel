package com.example.travel.ui.presentation.shared.circle

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.travel.R

@Preview
@Composable
private fun CirclePRev() {
    Circle(
        photo = "https://cdn-irec.r-99.com/sites/default/files/imagecache/copyright/user-images/267504/2Dm6RYf4INVB44rBq6mpw.jpg"
    )
}

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    photo: String?
) {
    if (photo != null) {
        Box(
            modifier = modifier
                .size(110.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFEBEBEB),
                    shape = CircleShape
                )
        ) {
            AsyncImage(
                model = photo,
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_profile_circle),
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
        }
    } else {
        Box(
            modifier = modifier
                .shadow(
                    elevation = 18.dp,
                    shape = CircleShape,
                    ambientColor = Color(0xFFF5F5F5),
                    spotColor = Color(0xFFF5F5F5)
                )
                .background(color = Color(0xFFF5F5F9), shape = CircleShape)
                .border(
                    width = 1.dp,
                    color = Color(0xFFEBEBEB),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_added_photo),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(45.dp)
            )
        }
    }

}