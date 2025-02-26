package com.example.examenrecuperacionsonia.data.remote

import com.example.examenrecuperacionsonia.data.model.NuevoPost
import com.example.examenrecuperacionsonia.data.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    fun getAllPosts(): Call<List<Post>>

    @GET("posts/{id}")
    fun getPostByID(@Path("id")id : Int): Call<Post>

    @POST("posts")
    fun addPost(@Body post: NuevoPost): Call<Post>

}