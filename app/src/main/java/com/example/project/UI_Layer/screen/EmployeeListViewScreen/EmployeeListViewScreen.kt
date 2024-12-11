package com.example.project.UI_Layer.screen.EmployeeListViewScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.project.R
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.navigation.Routes
import com.example.project.ui.theme.customBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeListViewScreen(viewModel: EmployeeViewModel, navHostController: NavHostController) {
    val res = viewModel.res.value?.data
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = customBlue,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {
                    IconButton(onClick = {
                        if (res != null && viewModel.selectedEmpId.value != null) {
                            navHostController.navigate(Routes.SelectedEmployeeScreen)
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_details),
                            contentDescription = "Localized description",
                            tint = Color.White
                        )

                    }
                },
            )
        },
    ) {
        it
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (res != null) {
                DataList(dataList = res, viewModel)
            } else {
                LazyColumn {
                    item {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(text = "Employee List Empty")

                        }
                    }
                }
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd).padding(35.dp)
                    .size(50.dp)

                    .clip(RoundedCornerShape(16.dp)),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = customBlue
                ),
                onClick = {
                    if (res != null && viewModel.selectedEmpId.value != null) {
                        navHostController.navigate(Routes.MapScreen)
                    }
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_mapview),
                    contentDescription = "",
                    modifier = Modifier.size(90.dp)
                )

            }
        }

    }
}
