package org.bryanollivie.project.feature.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(email = email, errorMessage = null)
    }

    fun updatePassword(password: String) {
        _uiState.value = _uiState.value.copy(password = password, errorMessage = null)
    }

    fun togglePasswordVisibility() {
        _uiState.value = _uiState.value.copy(passwordVisible = !_uiState.value.passwordVisible)
    }

    suspend fun login(): Boolean {
        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

        // Simulação de chamada API
        kotlinx.coroutines.delay(2000)

        return if (_uiState.value.email.isNotBlank() && _uiState.value.password.isNotBlank()) {
            _uiState.value = _uiState.value.copy(isLoading = false)
            true
        } else {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "Email e senha são obrigatórios"
            )
            false
        }
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val passwordVisible: Boolean = false
)