package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.FragmentIncredientListBinding
import com.example.nutralysis2.databinding.FragmentMainBinding
import com.example.nutralysis2.databinding.FragmentTotalNutrientsBinding
import com.example.nutralysis2.entities.nutrentanalysis
import com.example.nutralysis2.model.analyisiViewModel
import com.example.nutralysis2.model.analysisViewModelFactory
import com.example.nutralysis2.model.nutrationRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class IncredientListFragment : Fragment() {

    lateinit var ingredients: List<String>
    var navController: NavController? = null
    lateinit var analysisData: nutrentanalysis
    private lateinit var binding: FragmentIncredientListBinding


    val viewModel: analyisiViewModel by activityViewModels()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentIncredientListBinding.inflate(layoutInflater)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = IngredientsAdapter(listOf())
        navController = Navigation.findNavController(view)
        analysisData = viewModel.getanalisysdata()!!
        binding.rvIngredients.layoutManager = LinearLayoutManager(this.context)
        binding.rvIngredients.adapter = adapter
        adapter.items = analysisData.ingredients
        adapter.notifyDataSetChanged()

        binding.BTTotal.setOnClickListener {
            if (analysisData != null) {

                navController!!.navigate(
                    R.id.action_incredientListFragment_to_totalNutrients,

                    )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentIncredientListBinding.inflate(inflater, container, false)

        return binding.root

    }


}