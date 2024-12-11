package com.example.project.UI_Layer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.screen.EmployeeListViewScreen.EmployeeListViewScreen
import com.example.project.UI_Layer.screen.HomeScreen.HomeScreen
import com.example.project.UI_Layer.screen.ZigZagScreen.ZigZagScreen
import com.example.project.UI_Layer.screen.mapScreen.GoogleMapScreen
import com.example.project.UI_Layer.screen.selectedEmployeeScreen.SelectedEmployeeScreen
import com.example.project.UI_Layer.screen.splashScreen.SplashScreen

@Composable
fun NavHostGraph(viewModel: EmployeeViewModel,navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.SplashScreen) {

        composable<Routes.EmployeeListScreen> { EmployeeListViewScreen(viewModel = viewModel,navHostController) }
        composable<Routes.SelectedEmployeeScreen> {
            SelectedEmployeeScreen(viewModel,navHostController)
        }

        composable<Routes.MapScreen> { GoogleMapScreen(viewModel = viewModel, navHostController = navHostController) }


        composable<Routes.HomeScreen> { HomeScreen(viewModel = viewModel, navHostController = navHostController) }
        composable<Routes.ZigZagScreen> { ZigZagScreen() }
        composable<Routes.SplashScreen> { SplashScreen(viewModel = viewModel, navHostController = navHostController) }


    }

}