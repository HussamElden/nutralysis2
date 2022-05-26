package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.R
import com.example.nutralysis2.entities.nutrentanalysis
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_incredient_list.*
import kotlinx.android.synthetic.main.fragment_total_nutrients.*
import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

@SuppressLint("UseRequireInsteadOfGet")
class TotalNutrients : Fragment() {
    lateinit var analysisData: nutrentanalysis
    lateinit var listOfVitamins: List<List<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gson = Gson()
        val json = arguments!!.get("analysisData") as String

        analysisData = gson.fromJson(json, nutrentanalysis::class.java)
        Log.d("data", analysisData.toString())
        listOfVitamins = listOf(
            listOf(
                analysisData.totalNutrients.VITA_RAE.label,
                analysisData.totalNutrients.VITA_RAE.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.VITC.label,
                analysisData.totalNutrients.VITC.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.VITB6A.label,
                analysisData.totalNutrients.VITB6A.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.VITB12.label,
                analysisData.totalNutrients.VITB12.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.VITD.label,
                analysisData.totalNutrients.VITD.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.TOCPHA.label,
                analysisData.totalNutrients.TOCPHA.quantity.toString()
            ),
            listOf(
                analysisData.totalNutrients.VITK1.label,
                analysisData.totalNutrients.VITK1.quantity.toString()
            )

        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_nutrients, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = VitaminAdapter(listOfVitamins)
        rvVitamns
        rvVitamns.layoutManager = LinearLayoutManager(this.context)
        rvVitamns.adapter = adapter


        tvCalories.text = ((analysisData.calories * 100.0).roundToInt() / 100.0).toString()
        tvCholesterol.text =
            ((analysisData.totalNutrients.CHOLE.quantity * 100.0).roundToInt() / 100.0).toString()

        tvFat.text =
            ((analysisData.totalNutrients.FAT.quantity * 100.0).roundToInt() / 100.0).toString()

        tvCarbohydrate.text =
            ((analysisData.totalNutrients.CHOCDF.quantity * 100.0).roundToInt() / 100.0).toString()

        tvSodium.text =
            ((analysisData.totalNutrients.NA.quantity * 100.0).roundToInt() / 100.0).toString()

        tvProtein.text =
            ((analysisData.totalNutrients.PROCNT.quantity * 100.0).roundToInt() / 100.0).toString()
        tvIron.text =
            ((analysisData.totalNutrients.FE.quantity * 100.0).roundToInt() / 100.0).toString()

        tvPotassium.text =
            ((analysisData.totalNutrients.K.quantity * 100.0).roundToInt() / 100.0).toString()
        tvCalcium.text =
            ((analysisData.totalNutrients.CA.quantity * 100.0).roundToInt() / 100.0).toString()


    }
}