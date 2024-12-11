package com.example.project.data.remote.model

import kotlinx.serialization.Serializable


@Serializable
data class Data(
    val address: String="",
    val email: String="",
    val emp_Id: String="",
    val image: String="",
    val lat: String="",
    val lng: String="",
    val mobile_no: String="",
    val name: String="",
    val technology: String=""
)