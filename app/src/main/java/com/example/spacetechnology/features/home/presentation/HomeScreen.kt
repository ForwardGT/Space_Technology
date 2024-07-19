package com.example.spacetechnology.features.home.presentation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spacetechnology.features.nasa.presentation.NasaScreen
import com.example.spacetechnology.features.profile.presentation.ProfileScreen
import com.example.spacetechnology.features.spacex.presentation.SpacexScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {

    val viewModel: HomeViewModel = koinViewModel()
    val stateScreen by viewModel.screenState.collectAsState()

    Scaffold(
        bottomBar = {


            val barItem = listOf(
                NavigationItem.Home,
                NavigationItem.Nasa,
                NavigationItem.SpaceX,
                NavigationItem.Profile,
            )


            NavigationBar(
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .clip(shape = RoundedCornerShape(20.dp)),
                content = {

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

//                    viewModel.changeScreenState(currentDestination?.route)
                    Log.d("TAG", "HomeScreen: rout = $stateScreen")

                    barItem.forEach { item ->

                        val selected = currentDestination?.hierarchy?.any {
                            it.route == item.screen.route
                        } ?: false

                        NavigationBarItem(
                            selected = selected,
                            onClick = {

                                if (!selected) viewModel.changeScreenState(item)

//                                if (!selected) navController.navigateTo(item.screen.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.nameItem
                                )
                            },
                            label = { Text(text = item.nameItem) }
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {

            when (stateScreen) {
                NavigationItem.Home -> {}
                NavigationItem.Nasa -> NasaScreen()
                NavigationItem.Profile -> ProfileScreen()
                NavigationItem.SpaceX -> SpacexScreen()
            }
        }
    }
}