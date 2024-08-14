package com.example.spacetechnology.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStore
import com.example.spacetechnology.features.my_posts.domain.entity.PostMyPosts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelHome : ViewModel() {

    private val dataStore: DataStore by Injector.inject()

    private val _myPosts = MutableStateFlow<List<PostMyPosts>>(listOf())
    val myPosts = _myPosts.asStateFlow()

    init {
        getPostsFromMyPosts()
    }

    private fun getPostsFromMyPosts() {
        viewModelScope.launch {
            dataStore.getPostsForMyPosts().collect {
                _myPosts.value = it
            }
        }
    }
}