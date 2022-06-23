package com.example.nutralysis2.model

import com.example.nutralysis2.entities.Recipe
import com.example.nutralysis2.entities.nutrentanalysis
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.*
import org.json.JSONObject
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class nutrationRepo(private val api: nutrientsApi)  {

    suspend fun getNutrients(recipe: Recipe): Response<nutrentanalysis> {
       return api.getNutrients(requestBody = recipe)
    }
}