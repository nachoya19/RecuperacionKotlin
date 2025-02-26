package com.example.examenrecuperacionsonia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examenrecuperacionsonia.ui.screens.PostDetalles.PostDetalles
import com.example.examenrecuperacionsonia.ui.screens.PostsScreen.PostScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Destinations.POSTS_SCREEN
    ) {
        composable(Destinations.POSTS_SCREEN) {
            PostScreen(navController)
        }

        // En esta llamada a la vista, paso la ruta como string para poder trabajar con el id del producto
        // y poder llamar al producto por su id al pasarlo a la vista de sus detalles
        composable("post_details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toInt() ?: 0
            PostDetalles(navController,productId)
        }

    }
}