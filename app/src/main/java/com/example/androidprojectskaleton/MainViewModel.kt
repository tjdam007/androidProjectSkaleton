package com.example.androidprojectskaleton

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class MainUiState(
    val isLoading: Boolean = false,
    val message: String = ""
)

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    init {
        // Simulate loading state
        _uiState.value = _uiState.value.copy(isLoading = true)
    }
} 