package org.bryanollivie.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlinmultiplatformstarter.composeapp.generated.resources.Res
import kotlinmultiplatformstarter.composeapp.generated.resources.compose_multiplatform
import org.bryanollivie.project.feature.login.LoginScreen
import org.bryanollivie.project.feature.recoverylogin.RecoveryScreen
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication


/*@Composable
fun App() {
    KoinApplication(application = {
        modules(commonModule)
    }) {
        AppTheme {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                composable("login") {
                    LoginScreen(
                        onNavigateToRecovery = {
                            navController.navigate("recovery")
                        },
                        onLoginSuccess = {
                            // Navegar para tela principal do app
                            navController.navigate("home") {
                                popUpTo("login") { inclusive = true }
                            }
                        }
                    )
                }

                composable("recovery") {
                    RecoveryScreen(
                        onNavigateBack = {
                            navController.popBackStack()
                        }
                    )
                }

                composable("home") {
                    // Tela principal do app após login
                    HomeScreen(
                        onLogout = {
                            navController.navigate("login") {
                                popUpTo(0) { inclusive = true }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onLogout: () -> Unit) {
    // Implementação da tela principal
    androidx.compose.foundation.layout.Column {
        androidx.compose.material3.Text("Bem-vindo ao App!")
        androidx.compose.material3.Button(onClick = onLogout) {
            androidx.compose.material3.Text("Logout")
        }
    }
}*/
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
