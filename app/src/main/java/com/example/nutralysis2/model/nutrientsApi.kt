package com.example.nutralysis2.model

import com.example.nutralysis2.entities.nutrentanalysis
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface nutrientsApi {

    @POST("nutrition-details")
     suspend fun getNutrients(@Query("app_id") app_id:String = "47379841",
                             @Query("app_key") app_key:String= "d28718060b8adfd39783ead254df7f92",

                              @Body requestBody: RequestBody): Response<nutrentanalysis>
}