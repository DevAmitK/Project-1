package com.example.project.data.remote.api

import com.example.project.data.remote.model.EmployeeData
import retrofit2.http.GET

interface ApiService {
    @GET("getEmployeeList.php")
    suspend fun getEmployeeList(): EmployeeData
}

