package com.example.project.UI_Layer.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.remote.api.API_Builder
import com.example.project.data.remote.model.EmployeeData
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {
    // State to hold the selected emp_Id
    private val _selectedEmpId = mutableStateOf<String?>(null)
    val selectedEmpId: State<String?> = _selectedEmpId

    // Function to update selected emp_Id
    fun setSelectedEmpId(empId: String?) {
        _selectedEmpId.value = empId
    }

    var res = mutableStateOf<EmployeeData?>(null)

    init {
        fetchEmployees()
    }

    private fun fetchEmployees() {
        viewModelScope.launch {
             res.value =  API_Builder.provideAPI().getEmployeeList()

        }
    }
}
