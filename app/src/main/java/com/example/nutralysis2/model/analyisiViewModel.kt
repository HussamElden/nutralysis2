package com.example.nutralysis2.model

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nutralysis2.entities.Recipe
import com.example.nutralysis2.entities.nutrentanalysis
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class analyisiViewModel @Inject constructor(private val nutrationrepo: nutrationRepo) :
    ViewModel() {

    private var nutrientsLiveData = MutableLiveData<nutrentanalysis>()
     var nutrientsstateData = MutableStateFlow("String")
    var isSubmitButtonEnabled = MutableLiveData(false)
    private var showError = MutableLiveData(false)
    var isLoading = MutableLiveData(false)
    var isNutrientsAnalysed = MutableLiveData<Boolean>()

    fun getNutrents(ingredient: String = "") = CoroutineScope(Dispatchers.Main).launch {
        isLoading.value=true
        val arrayOfIngredient = ingredient.split("\n")

        val response =
            nutrationrepo.getNutrients(Recipe(ingr = arrayOfIngredient))
        nutrientsLiveData.value = response.body()?.let { dataCleaning(it) }
        isLoading.value=false
        if (response.isSuccessful)
            isNutrientsAnalysed.value = true
        else
            showError.value = true

    }

    fun getAnalyisisData(): nutrentanalysis? {

        return nutrientsLiveData.value
    }

    fun onIngredientsChanged(ingredientText: CharSequence) {
        isSubmitButtonEnabled.value = ingredientText.isNotEmpty()

    }

    fun observerdata(viewlifecycle:LifecycleOwner){
        nutrientsLiveData.observe(viewlifecycle){
            return@observe
        }
    }

    fun emmiter(newtext:String)= CoroutineScope(Dispatchers.Main).launch {
        nutrientsstateData.emit(newtext)
    }
    private fun dataCleaning(data: nutrentanalysis): nutrentanalysis {
        data.calories = ((data.calories * 100.0).roundToInt() / 100.0).toInt()
        data.totalNutrients.CHOLE.quantity =
            (data.totalNutrients.CHOLE.quantity * 100.0).roundToInt() / 100.0

        data.totalNutrients.FAT.quantity =
            (data.totalNutrients.FAT.quantity * 100.0).roundToInt() / 100.0

        data.totalNutrients.CHOCDF.quantity =
            (data.totalNutrients.CHOCDF.quantity * 100.0).roundToInt() / 100.0

        data.totalNutrients.NA.quantity =
            (data.totalNutrients.NA.quantity * 100.0).roundToInt() / 100.0

        data.totalNutrients.PROCNT.quantity =
            (data.totalNutrients.PROCNT.quantity * 100.0).roundToInt() / 100.0
        data.totalNutrients.FE.quantity =
            (data.totalNutrients.FE.quantity * 100.0).roundToInt() / 100.0

        data.totalNutrients.K.quantity =
            (data.totalNutrients.K.quantity * 100.0).roundToInt() / 100.0
        data.totalNutrients.CA.quantity =
            (data.totalNutrients.CA.quantity * 100.0).roundToInt() / 100.0

        return data
    }

}

