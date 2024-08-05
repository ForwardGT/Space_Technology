package com.example.spacetechnology

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.auth.presentation.AuthStateFirstLoad
import com.example.spacetechnology.features.auth.presentation.ViewModelAuth
import com.example.spacetechnology.navigation.NavigationGraph
import io.github.aagrishankov.platform.setContentThemeWithStatusBars
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        enableEdgeToEdge()
        setContentThemeWithStatusBars {

            val viewModel: ViewModelAuth = koinViewModel()
            val authorisedState by viewModel.startDestination.collectAsState()

            val navController = rememberNavController()
            SpaceTechnologyTheme(darkTheme = true) {

                if (authorisedState is AuthStateFirstLoad.Loading) {
                    CircularProgressIndicator()
                } else {
                    NavigationGraph(
                        startDestination = when (authorisedState) {
                            AuthStateFirstLoad.Loading -> AuthStateFirstLoad.Loading.route
                            AuthStateFirstLoad.Authorised -> AuthStateFirstLoad.Authorised.route
                            AuthStateFirstLoad.NotAuthorised -> AuthStateFirstLoad.NotAuthorised.route
                        },
                        navController = navController
                    )
                }
            }
        }
    }
}
