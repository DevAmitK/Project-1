package com.example.project.UI_Layer.screen.EmployeeListViewScreen

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project.UI_Layer.ViewModel.EmployeeViewModel
import com.example.project.data.remote.model.Data
import com.example.project.ui.theme.customBlue

@Composable
fun DataList(dataList: List<Data>, viewModel: EmployeeViewModel) {
    // Observe the selectedEmpId from the ViewModel
    val selectedEmpId by viewModel.selectedEmpId
    Log.d("selec", "DataList: $selectedEmpId")

    LazyColumn {
        items(dataList) { data ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
            ) {
                // Checkbox: Only check if this item is selected
                Checkbox(
                    checked = selectedEmpId == data.emp_Id,
                    onCheckedChange = { checked ->
                        // Only allow one selection at a time
                        if (checked) {
                            viewModel.setSelectedEmpId(data.emp_Id)
                        } else {
                            viewModel.setSelectedEmpId(null)
                        }
                    },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = customBlue, // Color when unchecked
                    )
                )


                // Display data
                ProfileCard(data = data)
            }
        }
    }
}


