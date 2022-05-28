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


     fun getNutrents(ingrediant: List<String> =listOf()) =CoroutineScope(Dispatchers.Main).launch {
         val jsonObject = JSONObject()
         jsonObject.put("ingr", JSONArray(ingrediant))


         // Convert JSONObject to String
         val jsonObjectString = jsonObject.toString()

         // Create RequestBody ( We're not using any converter, like GsonConverter, MoshiConverter e.t.c, that's why we use RequestBody )
         val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
//         Log.d("responsee", jsonObjectString)
         allObjLiveData.value=   nutrationrepo.api.getNutrients(requestBody=requestBody).body()

     }
    }

