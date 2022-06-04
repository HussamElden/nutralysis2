package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.FragmentTotalNutrientsBinding
import com.example.nutralysis2.entities.nutrentanalysis
import com.example.nutralysis2.model.analyisiViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

import kotlin.math.roundToInt

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
@AndroidEntryPoint
@SuppressLint("UseRequireInsteadOfGet")
class TotalNutrients : Fragment() {
    private lateinit var binding: FragmentTotalNutrientsBinding

    lateinit var analysisData: nutrentanalysis
    lateinit var listOfVitamins: List<List<String>>
    val viewModel: analyisiViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTotalNutrientsBinding.inflate(layoutInflater)
        analysisData = viewModel.getanalisysdata()!!

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
        FragmentTotalNutrientsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = VitaminAdapter(listOfVitamins)
        Log.d("moved data 2", viewModel.test)
        binding.rvVitamns.layoutManager = LinearLayoutManager(this.context)
        binding.rvVitamns.adapter = adapter


        binding.tvCalories.text = ((analysisData?.calories * 100.0).roundToInt() / 100.0).toString()
        binding.tvCholesterol.text =
            ((analysisData?.totalNutrients?.CHOLE.quantity * 100.0).roundToInt() / 100.0).toString()

        binding.tvFat.text =
            ((analysisData?.totalNutrients?.FAT.quantity * 100.0).roundToInt() / 100.0).toString()

        binding.tvCarbohydrate.text =
            ((analysisData?.totalNutrients?.CHOCDF.quantity * 100.0).roundToInt() / 100.0).toString()

        binding.tvSodium.text =
            ((analysisData.totalNutrients?.NA.quantity * 100.0).roundToInt() / 100.0).toString()

        binding.tvProtein.text =
            ((analysisData.totalNutrients?.PROCNT.quantity * 100.0).roundToInt() / 100.0).toString()
        binding.tvIron.text =
            ((analysisData.totalNutrients?.FE.quantity * 100.0).roundToInt() / 100.0).toString()

        binding.tvPotassium.text =
            ((analysisData.totalNutrients?.K.quantity * 100.0).roundToInt() / 100.0).toString()
        binding.tvCalcium.text =
            ((analysisData.totalNutrients?.CA.quantity * 100.0).roundToInt() / 100.0).toString()


    }
}