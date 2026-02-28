package com.example.travel.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travel.ui.approutes.AppRoutes

@Composable
fun NavigationBuilder(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoutes.SPLASH
    ){
        composable(AppRoutes.SPLASH){

        }
        composable(AppRoutes.AUTH){

        }
        composable(AppRoutes.AUTH_SECURE_CODE){

        }
        composable(AppRoutes.MAIN){

        }
        composable(AppRoutes.SEARCH){

        }
        composable(AppRoutes.REGISTER){

        }
        composable(AppRoutes.CREATE_PASSWORD){

        }
        composable(AppRoutes.CREATE_SECURE_CODE){

        }
        composable(AppRoutes.PROFILE){

        }
        composable(AppRoutes.TRAVELS){

        }
        composable(AppRoutes.BOOKING){

        }
        composable(AppRoutes.CART){

        }
    }
}