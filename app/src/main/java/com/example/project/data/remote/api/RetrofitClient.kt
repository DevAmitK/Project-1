package com.example.project.data.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object API_Builder {
    val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.MINUTES)
        .build()

    fun provideAPI() =
        Retrofit.Builder()
        //    .client(client)
            .baseUrl("http://codexalters-techlabs.com/employee/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}
