package com.example.spacetechnology.features.nasa.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.nasa.domain.entity.PostApod
import com.example.spacetechnology.features.nasa.domain.entity.RepositoryNasa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelNasa : ViewModel() {

    private val repository: RepositoryNasa by Injector.inject()

    private val _postApod = MutableStateFlow(
        PostApod(
            date = "",
            urlImage = "",
            explanation = "",
            title = ""
        )
    )
    val postApod = _postApod.asStateFlow()


    init {
        loadLastApod()
    }


    private fun loadLastApod() {
        viewModelScope.launch {
            val post = repository.loadApod()
            _postApod.value = post
        }
    }
}