package com.example.project

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.navigation.BottomNavigationBar
import com.example.project.UI_Layer.navigation.Routes
import com.example.project.UI_Layer.screen.App

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            val viewModel by viewModels<EmployeeViewModel>()
            val navHostController = rememberNavController()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination?.route
            val shouldShowBottomBar = remember { mutableStateOf(false) }

//            LaunchedEffect(currentDestination) {
//                shouldShowBottomBar.value = when (currentDestination) {
//                    Routes.HomeScreen::class.qualifiedName, Routes.ZigZagScreen::class.qualifiedName, Routes.MapScreen::class.qualifiedName -> true
//                    else -> false
//                }
//            }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
//                bottomBar = {
//                    if (shouldShowBottomBar.value) {
//                        BottomNavigationBar(navController = navHostController)
//                    }
//                },
                content = { innerPadding ->
                    Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
                        //NavHostGraph(viewModel = viewModel, navHostController = navHostController)
                        App(navController = navHostController, viewModel = viewModel)
                    }
                }
            )
        }
    }

}