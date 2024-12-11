package com.example.project.UI_Layer.screen.mapScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.project.UI_Layer.screen.EmployeeListViewScreen.ProfileCard
import com.example.project.data.remote.model.Data
import com.example.project.ui.theme.customBlue
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleMapScreen(
    navHostController: NavHostController,
    viewModel: EmployeeViewModel,
) {

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

                )
        }
    ) {
        it
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val res = viewModel.res.value
            val selectedEmpId = viewModel.selectedEmpId.value

            Box(modifier = Modifier.padding(bottom = 20.dp)) {


                // State to track the currently selected employee
                val selectedEmployeeState = remember { mutableStateOf<Data?>(null) }

                if (res != null && selectedEmpId != null) {
                    val selectedEmployee = res.data[selectedEmpId.toInt() - 1]

                    val defaultCameraPosition =
                        CameraPosition.fromLatLngZoom(
                            LatLng(
                                selectedEmployee.lat.toDouble(),
                                selectedEmployee.lng.toDouble()
                            ),
                            4f
                        )
                    val cameraPositionState = rememberCameraPositionState {
                        position = defaultCameraPosition
                    }

                    val mapProperties by remember {
                        mutableStateOf(
                            MapProperties(
                                mapType = MapType.NORMAL
                            )
                        )
                    }
                    val mapUiSettings by remember {
                        mutableStateOf(
                            MapUiSettings(
                                compassEnabled = false
                            )
                        )
                    }

                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        uiSettings = mapUiSettings,
                        cameraPositionState = cameraPositionState,
                        properties = mapProperties
                    ) {
                        res.data.forEach { employee ->
                            val locationState = rememberMarkerState(
                                position = LatLng(
                                    employee.lat.toDouble(),
                                    employee.lng.toDouble()
                                )
                            )
                            Marker(
                                state = locationState,
                                draggable = false,
                                title = employee.name,
                                onClick = {
                                    // Update the selected employee when a marker is clicked
                                    selectedEmployeeState.value = employee
                                    true
                                }
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp)
                            .align(Alignment.BottomEnd)
                    ) {
                        // Show card with details of the selected employee at the bottom
                        if (selectedEmployeeState.value != null) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                // Checkbox: Only check if this item is selected
                                Checkbox(
                                    checked = true,
                                    onCheckedChange = { checked -> }
                                )
                                // Display data
                                ProfileCard(data = selectedEmployeeState.value!!)
                            }
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()

                            ) {
                                // Checkbox: Only check if this item is selected
                                Checkbox(
                                    checked = true,
                                    onCheckedChange = { checked -> }
                                )
                                // Display data
                                ProfileCard(data = selectedEmployee)
                            }
                        }
                    }
                }
            }

            IconButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 35.dp, end = 10.dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    ,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = customBlue
                ),
                onClick = {
                    if (res != null && viewModel.selectedEmpId.value != null) {
                        navHostController.navigate(Routes.EmployeeListScreen)
                    }
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_listview),
                    contentDescription = "",
                    modifier = Modifier.size(90.dp)
                )

            }
        }

    }
}