package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spacetechnology.core.ui.SpaceTechColor
import com.example.spacetechnology.core.utils.extensions.thenIf
import com.example.spacetechnology.features.home.presentation.NavigationItem
import com.example.spacetechnology.navigation.navigateTo

@Composable
fun SpaceTechNavigationBar(
    navController: NavController
) {
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

            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                barItem.forEach { item ->

                    val selected = currentDestination?.hierarchy?.any {
                        it.route == item.screen.route
                    } ?: false

                    IconButton(
                        enabled = true,
                        onClick = { if (!selected) navController.navigateTo(item.screen.route) }
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .thenIf(
                                    selected,
                                    Modifier.background(SpaceTechColor.iconColorBackground)
                                )
                        ) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = item.icon,
                                contentDescription = item.nameItem,
                            )
                        }
                    }
                }
            }
        }
    )
}