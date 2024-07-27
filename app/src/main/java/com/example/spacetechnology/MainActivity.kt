package com.example.spacetechnology

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.navigation.NavigationGraph
import io.github.aagrishankov.platform.setContentThemeWithStatusBars

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        enableEdgeToEdge()
        setContentThemeWithStatusBars {

            val navController = rememberNavController()
            SpaceTechnologyTheme(darkTheme = true) {

                NavigationGraph(navController = navController)
            }
        }
    }
}
