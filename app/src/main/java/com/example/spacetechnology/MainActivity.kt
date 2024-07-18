package com.example.spacetechnology

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.ui.theme.SpaceTechnologyTheme
import com.example.spacetechnology.navigation.NavigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            SpaceTechnologyTheme {
                NavigationGraph(navController = navController)
            }
        }
    }
}
