package com.example.examenrecuperacionsonia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.examenrecuperacionsonia.ui.navigation.Destinations
import com.example.examenrecuperacionsonia.ui.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    // Creamos la variable navController para manejar la navegacion
    val navController = rememberNavController()
    val currentRoute = remember { mutableStateOf(Destinations.POSTS_SCREEN) }
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            currentRoute.value = destination.route ?: Destinations.POSTS_SCREEN
        }
    }
    // Declaramos el Scaffold y le pasamos el content que va a ir cambiando entre las vistas
    Scaffold(
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavGraph(navController)
            }

        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   
}