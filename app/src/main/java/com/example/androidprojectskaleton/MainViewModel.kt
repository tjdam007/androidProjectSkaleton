package com.example.androidprojectskaleton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprojectskaleton.data.model.Post
import com.example.androidprojectskaleton.data.repository.PostRepository
import com.example.androidprojectskaleton.util.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    init {
        loadPosts()
    }
    
    fun loadPosts() {
        viewModelScope.launch {
            Logger.d("Loading posts in ViewModel")
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val posts = postRepository.getPosts()
                Logger.i("Successfully loaded ${posts.size} posts in ViewModel")
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    posts = posts
                )
            } catch (e: Exception) {
                Logger.e(e, "Error loading posts in ViewModel")
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error occurred"
                )
            }
        }
    }
    

} 