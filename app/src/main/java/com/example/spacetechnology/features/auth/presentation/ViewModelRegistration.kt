package com.example.spacetechnology.features.auth.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import com.example.spacetechnology.features.auth.domain.entity.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelRegistration : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()

    private val _registrationState = MutableStateFlow(RegistrationState())
    val registrationState = _registrationState.asStateFlow()


    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var repeatPassword by mutableStateOf("")


    fun setUserData() {
        viewModelScope.launch {
            dataStore.setUserData(
                userData = UserData(
                    email = email,
                    password = password
                )
            )
        }
    }

    fun getUserData(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            dataStore.getUserData().collect { storedUserData ->
                val isMatch = storedUserData.email == email && storedUserData.password == password
                onResult(isMatch)
            }
        }
    }
}