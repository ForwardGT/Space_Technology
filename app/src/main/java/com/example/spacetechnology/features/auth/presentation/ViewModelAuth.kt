package com.example.spacetechnology.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.core.utils.validators.validatorLogin
import com.example.spacetechnology.core.utils.validators.validatorRegistration
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStore
import com.example.spacetechnology.features.auth.domain.entity.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelAuth : ViewModel() {

    private val dataStore: DataStore by Injector.inject()

    private val _authState = MutableStateFlow(AuthState())
    val authState = _authState.asStateFlow()

    private val _isLogin = MutableStateFlow<Boolean?>(null)
    val isLogin = _isLogin.asStateFlow()


    init {
        getIsLoginIn()
    }


    fun setIsLoginIn(loginIn: Boolean) {
        viewModelScope.launch {
            dataStore.setIsLoginUser(loginIn)
        }
    }


    private fun getIsLoginIn() {
        viewModelScope.launch {
            dataStore.getIsLoginUser().collect {
                _isLogin.value = it
            }
        }
    }


    fun setEmail(email: String) {
        _authState.reduce {
            it.copy(
                email = email,
                errors = it.errors.copy(emailError = "")
            )
        }
    }


    fun setPassword(password: String) {
        _authState.reduce {
            it.copy(
                password = password,
                errors = it.errors.copy(passwordError = "")
            )
        }
    }


    fun setRepeatPassword(repeatPassword: String) {
        _authState.reduce {
            it.copy(
                repeatPassword = repeatPassword,
                errors = it.errors.copy(repeatPasswordError = "")
            )
        }
    }


    fun clearAuthState() {
        _authState.reduce {
            it.copy(
                registrationSuccess = false
            )
        }
    }


    fun setUserData(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val errors = validatorRegistration(
                email = _authState.value.email,
                password = _authState.value.password,
                repeatPassword = _authState.value.repeatPassword
            )
            _authState.reduce {
                it.copy(errors = errors)
            }

            if (errors.emailError.isBlank() && errors.passwordError.isBlank() && errors.repeatPasswordError.isBlank()) {
                dataStore.setUserData(
                    userData = UserData(
                        email = _authState.value.email,
                        password = _authState.value.password
                    )
                )
                _authState.reduce {
                    it.copy(registrationSuccess = true)
                }
                val isMatch = (_authState.value.registrationSuccess)
                onResult(isMatch)
            }
        }.invokeOnCompletion { throwError ->
            if (throwError != null) {
                _authState.reduce {
                    it.copy(
                        registrationSuccess = false,
                        errors = it.errors.copy(
                            repeatPasswordError = "Unknown error"
                        )
                    )
                }
            }
        }
    }


    fun getUserData(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val errors = validatorLogin(
                email = _authState.value.email,
                password = _authState.value.password,
            )
            _authState.reduce {
                it.copy(errors = errors)
            }

            if (errors.emailError == "" && errors.passwordError == "") {
                dataStore.getUserData().collect { storedUserData ->

                    if (storedUserData.email != _authState.value.email) {
                        _authState.reduce {
                            it.copy(
                                errors = it.errors.copy(
                                    emailError = "Email doesn't exist."
                                )
                            )
                        }
                    }

                    if (storedUserData.email == _authState.value.email && storedUserData.password != _authState.value.password) {
                        _authState.reduce {
                            it.copy(
                                errors = it.errors.copy(
                                    passwordError = "Wrong password"
                                )
                            )
                        }
                    }
                    val isMatch =
                        storedUserData.email == _authState.value.email && storedUserData.password == _authState.value.password
                    onResult(isMatch)

                    if (isMatch) _authState.reduce {
                        it.copy(registrationSuccess = true)
                    }
                }
            }
        }.invokeOnCompletion { throwError ->
            if (throwError != null) {
                _authState.reduce {
                    it.copy(
                        loginSuccess = false,
                        errors = it.errors.copy(
                            passwordError = "Unknown error"
                        )
                    )
                }
            }
        }
    }
}