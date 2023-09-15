package com.olubankeeboda.mobileresume.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.olubankeeboda.mobileresume.ui.edit.EditDestination
import com.olubankeeboda.mobileresume.ui.edit.EditRoute
import com.olubankeeboda.mobileresume.ui.home.HomeDestination
import com.olubankeeboda.mobileresume.ui.home.HomeScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun MobileResumeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToEditScreen = { navController.navigate(EditDestination.route) },
            )
        }
        composable(route = EditDestination.route) {
            EditRoute(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}