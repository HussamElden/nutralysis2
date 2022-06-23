package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.FragmentIncredientListBinding
import com.example.nutralysis2.model.analyisiViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IncredientListFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var binding: FragmentIncredientListBinding
    private val viewModel: analyisiViewModel by activityViewModels()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentIncredientListBinding.inflate(layoutInflater)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = IngredientsAdapter(listOf())
        navController = Navigation.findNavController(view)
        binding.rvIngredients.layoutManager = LinearLayoutManager(this.context)
        binding.rvIngredients.adapter = adapter
        adapter.items = viewModel.getAnalyisisData()!!.ingredients

        adapter.notifyDataSetChanged()

        binding.BTTotal.setOnClickListener {
            if (viewModel.getAnalyisisData() != null) {

                navController.navigate(
                    R.id.action_incredientListFragment_to_totalNutrients,

                    )
            }
        }
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            navController.navigate(
                R.id.action_incredientListFragment_to_mainFrag,

                )
        }
        callback.isEnabled=true

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentIncredientListBinding.inflate(inflater, container, false)

        return binding.root

    }


}