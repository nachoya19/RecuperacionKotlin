package com.example.examenrecuperacionsonia.ui.screens.PostDetalles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PostDetalles(navController: NavController,postId: Int,viewModel: PostDetallesViewModel = hiltViewModel()) {
    val post by viewModel.postDetail.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPostDetail(postId) //Llamo al metodo que obtiene el producto por id
    }

    Column {

        // Trabajo con el post para mostrar sus datos

        post?.let {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text(it.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(it.body, fontSize = 16.sp)
            }
        }

        // Boton para volver

        Button(onClick = {navController.popBackStack()}) {
            Text("Volver")
        }

    }


}