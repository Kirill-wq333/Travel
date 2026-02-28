package com.example.travel.ui.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travel.ui.approutes.AppRoutes
import com.example.travel.ui.presentation.navigation.NavigationBuilder
import com.example.travel.ui.presentation.shared.bottomBar.TravelBottomBar

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val routes = listOf(
        AppRoutes.PROFILE,
        AppRoutes.SEARCH,
        AppRoutes.MAIN,
        AppRoutes.TRAVELS
    )
    val current = navController.currentBackStackEntryAsState()
        .value
        ?.destination
        ?.route

    val showBottomBar = current in routes

    HostScaffold(
        bottomBar = {
            if (showBottomBar){
                TravelBottomBar(
                    navController = navController
                )
            }
        },
        content = { padding ->
            NavigationBuilder(
                navController = navController,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        }
    )
}

@Composable
fun HostScaffold(
    bottomBar: @Composable (() -> Unit) = {},
    content: @Composable ((PaddingValues) -> Unit) = {},
) {
    Scaffold(
//        snackbarHost = ,
        bottomBar = bottomBar,
        content = content,

    )

}