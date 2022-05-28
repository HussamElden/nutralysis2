package com.example.nutralysis2.model

import okhttp3.*
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class nutrationRepo  {
    val api:nutrientsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.edamam.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(nutrientsApi::class.java)
    }

}