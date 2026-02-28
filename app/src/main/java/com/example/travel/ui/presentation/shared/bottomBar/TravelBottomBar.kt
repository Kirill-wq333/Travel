package com.example.travel.ui.presentation.shared.bottomBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travel.R
import com.example.travel.ui.approutes.AppRoutes
import com.example.travel.ui.presentation.shared.divider.TravelHorizontalDivider
import com.example.travel.ui.theme.TravelColors
import com.example.travel.ui.theme.TravelTypography

@Composable
fun TravelBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val bottomBar = listOf(
        TravelBottomBarC(
            icon = R.drawable.ic_main,
            name = "Главная",
            route = AppRoutes.MAIN
        ),
        TravelBottomBarC(
            icon = R.drawable.ic_search,
            name = "Поиск",
            route = AppRoutes.MAIN
        ),
        TravelBottomBarC(
            icon = R.drawable.ic_travels,
            name = "Поездки",
            route = AppRoutes.MAIN
        ),
        TravelBottomBarC(
            icon = R.drawable.ic_profile,
            name = "Профиль",
            route = AppRoutes.MAIN
        ),
    )

    val current = navController
        .currentBackStackEntryAsState()
        .value?.destination?.route

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TravelHorizontalDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 7.dp,
                    end = 7.dp,
                    top = 8.dp,
                    bottom = 18.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(19.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            bottomBar.forEach { c ->
                val isSelected = current == c.route

                BottomBarItem(
                    icon = c.icon,
                    name = c.name,
                    isSelected = isSelected,
                    onClick = { navController.navigate(c.route) }
                )
            }
        }
    }
}

@Composable
fun BottomBarItem(
    icon: Int,
    name: String,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    Column(
        modifier = Modifier
            .clickable(
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .size(32.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = if (isSelected) TravelColors.accent else Color(0xFFB8C1CC)
            )
        }
        Text(
            text = name,
            color = if (isSelected) TravelColors.accent else Color(0xFFB8C1CC),
            style = TravelTypography.captionRegular12
        )
    }
}

data class TravelBottomBarC(
    val name: String,
    val route: String,
    val icon: Int
)