package org.bryanollivie.project.feature.recoverylogin

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// ViewModel para Recuperação
class RecoveryLoginViewModel {
    private val _uiState = MutableStateFlow(RecoveryUiState())
    val uiState: StateFlow<RecoveryUiState> = _uiState.asStateFlow()

    fun updateEmail(email: String) {
        _uiState.value = _uiState.value.copy(email = email, errorMessage = null, isSuccess = false)
    }

    suspend fun sendRecoveryEmail(): Boolean {
        _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

        // Simulação de chamada API
        kotlinx.coroutines.delay(2000)

        return if (isValidEmail(_uiState.value.email)) {
            _uiState.value = _uiState.value.copy(isLoading = false, isSuccess = true)
            true
        } else {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "Por favor, insira um email válido"
            )
            false
        }
    }

    private fun isValidEmail(email: String): Boolean {
        //return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return true
    }
}
data class RecoveryUiState(
    val email: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)
