package com.example.project.UI_Layer.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.navigation.BottomNavigationBar
import com.example.project.UI_Layer.navigation.NavHostGraph
import com.example.project.UI_Layer.navigation.Routes

@Composable
fun App(navController: NavHostController, viewModel: EmployeeViewModel) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    val shouldShowBottomBar = remember { mutableStateOf(false) }
    LaunchedEffect(currentDestination) {
        shouldShowBottomBar.value = when (currentDestination) {
            Routes.HomeScreen::class.qualifiedName, Routes.ZigZagScreen::class.qualifiedName, Routes.MapScreen::class.qualifiedName -> true
            else -> false
        }


    }
    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar.value) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) {

        it
        NavHostGraph(viewModel = viewModel, navHostController = navController)


    }

}