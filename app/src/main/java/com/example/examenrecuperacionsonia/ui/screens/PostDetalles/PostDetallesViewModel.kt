package com.example.examenrecuperacionsonia.ui.screens.PostDetalles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenrecuperacionsonia.data.model.Post
import com.example.examenrecuperacionsonia.data.repositorio.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetallesViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel(){
    private val _postDetail = MutableStateFlow<Post?>(null)
    val postDetail: StateFlow<Post?> = _postDetail

    // Metodo para llamar al post por el id
    // @Param: Id del post
    fun getPostDetail(postId: Int) {
        viewModelScope.launch {
            val post = postRepository.getPostById(postId)
            _postDetail.value = post
        }
    }
}