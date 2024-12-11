package com.example.project.UI_Layer.screen.HomeScreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.screen.EmployeeListViewScreen.EmployeeListViewScreen

@Composable
fun HomeScreen(viewModel: EmployeeViewModel , navHostController: NavHostController) {

    EmployeeListViewScreen(viewModel,navHostController)
}