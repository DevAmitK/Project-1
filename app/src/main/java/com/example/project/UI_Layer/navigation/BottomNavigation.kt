package com.example.project.UI_Layer.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.project.ui.theme.customBlue
import com.example.project.ui.theme.customWhite


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    Surface(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ),
        tonalElevation = 30.dp,
        shadowElevation = 30.dp,
        ) {
        BottomNavigation(
            modifier = Modifier,
            backgroundColor = customWhite,
        ) {


            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = null,
                        tint =
                        if (Routes.HomeScreen::class.qualifiedName == currentDestination ||
                            Routes.MapScreen::class.qualifiedName == currentDestination ||
                            Routes.SelectedEmployeeScreen::class.qualifiedName == currentDestination
                        ) {
                            customBlue
                        } else {
                            Color.Black
                        }
                    )
                },
                label = {
                    Text(
                        "Home",
                        color = if (Routes.HomeScreen::class.qualifiedName == currentDestination ||
                            Routes.MapScreen::class.qualifiedName == currentDestination ||
                            Routes.SelectedEmployeeScreen::class.qualifiedName == currentDestination
                        ) {
                            customBlue
                        } else {
                            Color.Black
                        }
                    )
                },
                selected = false,
                onClick = {
                    if (Routes.HomeScreen::class.qualifiedName != currentDestination) {
                        navController.navigate(Routes.HomeScreen)
                    }

                }
            )
            BottomNavigationItem(
                icon = {

                    Icon(
                        Icons.Filled.Settings, contentDescription = null,
                        tint = if (Routes.ZigZagScreen::class.qualifiedName == currentDestination) {
                            customBlue
                        } else {
                            Color.Black
                        }
                    )

                },
                label = {
                    Text(
                        "Zig Zag",
                        color =
                        if (Routes.ZigZagScreen::class.qualifiedName == currentDestination) {
                            customBlue
                        } else {
                            Color.Black
                        }
                    )
                },
                selected = false,
                onClick = {
                    if (Routes.ZigZagScreen::class.qualifiedName != currentDestination) {
                        navController.navigate(Routes.ZigZagScreen)
                    }
                }
            )
        }
    }
}

