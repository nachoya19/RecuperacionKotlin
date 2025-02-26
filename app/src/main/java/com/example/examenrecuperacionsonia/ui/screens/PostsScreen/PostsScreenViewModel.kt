package com.example.examenrecuperacionsonia.ui.screens.PostsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenrecuperacionsonia.data.model.NuevoPost
import com.example.examenrecuperacionsonia.data.model.Post
import com.example.examenrecuperacionsonia.data.repositorio.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostsScreenViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel(){
    private val _postsList = MutableStateFlow<List<Post>>(emptyList())
    val postsList: StateFlow<List<Post>> = _postsList

    // Metodo para obtener los posts
    fun getPosts() {
        viewModelScope.launch {
            val result = postRepository.fetchPosts()
            if (result != null) {
                _postsList.value = result
            }
        }
    }

    // Metodo para añadir un post
    // @Param: paso por parametro el nuevo post
    fun addPost(post: NuevoPost){
        viewModelScope.launch {
            postRepository.createPost(post)
        }
    }

}