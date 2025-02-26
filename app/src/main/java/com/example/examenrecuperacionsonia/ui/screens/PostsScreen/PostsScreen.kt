package com.example.examenrecuperacionsonia.ui.screens.PostsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.examenrecuperacionsonia.data.model.NuevoPost
import com.example.examenrecuperacionsonia.data.model.Post

@Composable
fun PostScreen(navController: NavController, viewModel: PostsScreenViewModel = hiltViewModel()){
    var title by remember { mutableStateOf("") }
    var body by remember { mutableStateOf("") }
    val postsList by viewModel.postsList.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getPosts()  // Llamo al metodo que obtiene los productos
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            TextField(value = title, onValueChange = { title = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = body, onValueChange = { body = it }, label = { Text("Cuerpo") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                // If para que si los campos no estan vacios se haga el post
                // no he conseguido alinear el boton
                if(title.isNotEmpty() && body.isNotEmpty()){
                    val post = NuevoPost(title, body, 1)
                    viewModel.addPost(post)
                    viewModel.getPosts()
                }
            }) {
                Text("Enviar")
            }
        }
        // En el LazyColumn, en el onclick del card, mando por parametro la ruta con el id del producto para pasarselo a
        // la vista de los detalles del post
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(postsList) { post ->
                PostCard(post,
                    onPostClick = { productId -> navController.navigate("post_details/$productId")})

            }
        }
    }


}

// Creo la carta y paso por parametros:
// @Param post: El objeto del post
// @Param onPostClick: el metodo del boton
// Creo que no se esta haciendo el comentario como javadoc
@Composable
fun PostCard(post: Post, onPostClick: (Int) -> Unit ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(5.dp),
        onClick = { onPostClick(post.id) }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(post.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }

}