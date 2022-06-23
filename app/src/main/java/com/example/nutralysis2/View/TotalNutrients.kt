package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.databinding.FragmentTotalNutrientsBinding
import com.example.nutralysis2.entities.nutrentanalysis
import com.example.nutralysis2.model.analyisiViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
@AndroidEntryPoint
@SuppressLint("UseRequireInsteadOfGet")
class TotalNutrients : Fragment() {
    private lateinit var binding: FragmentTotalNutrientsBinding
    lateinit var analysisData: nutrentanalysis
    lateinit var listOfVitamins: List<List<String>>
    private val viewModel: analyisiViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTotalNutrientsBinding.inflate(layoutInflater)
        analysisData = viewModel.getAnalyisisData()!!

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

        binding.rvVitamns.layoutManager = LinearLayoutManager(this.context)
        binding.rvVitamns.adapter = adapter


        binding.tvCalories.text = analysisData.calories.toString()
        binding.tvCholesterol.text =
            analysisData.totalNutrients.CHOLE.quantity.toString()

        binding.tvFat.text =
            analysisData.totalNutrients.FAT.quantity.toString()

        binding.tvCarbohydrate.text =
            analysisData.totalNutrients.CHOCDF.quantity.toString()

        binding.tvSodium.text =
            analysisData.totalNutrients.NA.quantity.toString()

        binding.tvProtein.text =
            analysisData.totalNutrients.PROCNT.quantity.toString()
        binding.tvIron.text =
            analysisData.totalNutrients.FE.quantity.toString()
        binding.tvPotassium.text =
            analysisData.totalNutrients.K.quantity.toString()
        binding.tvCalcium.text =
            analysisData.totalNutrients.CA.quantity.toString()


    }
}