package com.example.spacetechnology.features.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacetechnology.core.utils.extensions.reduce
import com.example.spacetechnology.core.utils.validators.validatorLogin
import com.example.spacetechnology.core.utils.validators.validatorRegistration
import com.example.spacetechnology.di.Injector
import com.example.spacetechnology.features.auth.domain.DataStoreManager
import com.example.spacetechnology.features.auth.domain.entity.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelAuth : ViewModel() {

    private val dataStore: DataStoreManager by Injector.inject()

    private val _registrationState = MutableStateFlow(RegistrationState())
    val registrationState = _registrationState.asStateFlow()

    val setEmail = { email: String ->
        _registrationState.reduce {
            it.copy(
                email = email,
                errors = it.errors.copy(emailError = "")
            )
        }
    }

    val setPassword = { password: String ->
        _registrationState.reduce {
            it.copy(
                password = password,
                errors = it.errors.copy(passwordError = "")
            )
        }
    }

    val setRepeatPassword = { repeatPassword: String ->
        _registrationState.reduce {
            it.copy(
                repeatPassword = repeatPassword,
                errors = it.errors.copy(repeatPasswordError = "")
            )
        }
    }

    fun clearState() {
        _registrationState.reduce {
            it.copy(
                registrationSuccess = false
            )
        }
    }

    fun setUserData(onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val errors = validatorRegistration(
                email = _registrationState.value.email,
                password = _registrationState.value.password,
                repeatPassword = _registrationState.value.repeatPassword
            )
            _registrationState.reduce {
                it.copy(errors = errors)
            }
            if (errors.emailError == "" && errors.passwordError == "" && errors.repeatPasswordError == "") {
                dataStore.setUserData(
                    userData = UserData(
                        email = _registrationState.value.email,
                        password = _registrationState.value.password
                    )
                )
                _registrationState.reduce {
                    it.copy(registrationSuccess = true)
                }
                val isMatch = (_registrationState.value.registrationSuccess)
                onResult(isMatch)
            }
        }.invokeOnCompletion { throwError ->
            if (throwError != null) {
                _registrationState.reduce {
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
                email = _registrationState.value.email,
                password = _registrationState.value.password,
            )
            _registrationState.reduce {
                it.copy(errors = errors)
            }
            if (errors.emailError == "" && errors.passwordError == "") {
                dataStore.getUserData().collect { storedUserData ->
                    val isMatch = storedUserData.email == _registrationState.value.email && storedUserData.password == _registrationState.value.password
                    onResult(isMatch)

                    if (isMatch) _registrationState.reduce {
                        it.copy(registrationSuccess = true)
                    }
                }
            }
        }.invokeOnCompletion { throwError ->
            if (throwError != null) {
                _registrationState.reduce {
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