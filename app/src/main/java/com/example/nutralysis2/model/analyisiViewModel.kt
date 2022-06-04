package com.example.nutralysis2.model

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutralysis2.entities.nutrentanalysis
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class analyisiViewModel @Inject constructor(private val nutrationrepo: nutrationRepo): ViewModel() {

    var allObjLiveData = MutableLiveData<nutrentanalysis>()
    var test=""

     suspend fun getNutrents(ingrediant: String=""):Boolean{
         var arrayOfIngrediants = ingrediant.split("\n")
         val jsonObject = JSONObject()
         jsonObject.put("ingr", JSONArray(arrayOfIngrediants))


         // Convert JSONObject to String
         val jsonObjectString = jsonObject.toString()

         // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
         val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
//         Log.d("responsee", jsonObjectString)
         var response =nutrationrepo.api.getNutrients(requestBody=requestBody)
         allObjLiveData.value=   response.body()

        return response.isSuccessful

     }
    fun getanalisysdata(): nutrentanalysis? {
        Log.d("getanalisysdata",  allObjLiveData.value.toString())
        return allObjLiveData.value
    }
    fun isButtonDisplayed(textAfter:Int):Boolean{
        return textAfter != 0

    }

    }

