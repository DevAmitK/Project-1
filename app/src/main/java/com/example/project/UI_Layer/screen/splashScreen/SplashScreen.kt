package com.example.project.UI_Layer.screen.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.project.R
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.navigation.NavHostGraph
import com.example.project.UI_Layer.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHostController: NavHostController,viewModel: EmployeeViewModel) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate(Routes.HomeScreen)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        // Add background image
        Image(
            painter = painterResource(id = R.drawable.ic_splash_bg), // Replace with your drawable image
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.ic_splash_logo), // Replace with your drawable image
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}