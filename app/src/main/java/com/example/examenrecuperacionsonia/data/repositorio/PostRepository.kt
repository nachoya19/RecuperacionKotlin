package com.example.examenrecuperacionsonia.data.repositorio

import com.example.examenrecuperacionsonia.data.model.NuevoPost
import com.example.examenrecuperacionsonia.data.model.Post
import com.example.examenrecuperacionsonia.data.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepository @Inject constructor(){

    // Metodo para obtener todos los posts
    suspend fun fetchPosts(): List<Post>? {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofitInstance.api.getAllPosts().execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }


    // Metodo para obtener un post por ID
    suspend fun getPostById(id: Int): Post? {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofitInstance.api.getPostByID(id).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    // Metodo para crear un post
    suspend fun createPost(post: NuevoPost): Post? {
        return withContext(Dispatchers.IO) {
            val response =
                RetrofitInstance.api.addPost(post).execute()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

}