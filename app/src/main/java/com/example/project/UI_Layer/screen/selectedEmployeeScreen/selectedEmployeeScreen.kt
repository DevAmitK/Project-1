package com.example.project.UI_Layer.screen.selectedEmployeeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.UI_Layer.screen.EmployeeListViewScreen.ProfileCard
import com.example.project.ui.theme.customBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectedEmployeeScreen(viewModel: EmployeeViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = customBlue,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(
                        "Employee List ",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigateUp()
                        }
                    )
                }

            )
        }
    ) {
        it

        Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {


            if (viewModel.res != null && viewModel.selectedEmpId.value != null) {
                val data =
                    viewModel.res.value!!.data.get(viewModel.selectedEmpId.value!!.toInt() - 1)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    // Checkbox: Only check if this item is selected
                    Checkbox(
                        checked = true,
                        onCheckedChange = { checked ->
                            // Only allow one selection at a time
                        }
                    )
                    // Display data
                    ProfileCard(data = data)
                }

            } else {

            }
        }
    }
}