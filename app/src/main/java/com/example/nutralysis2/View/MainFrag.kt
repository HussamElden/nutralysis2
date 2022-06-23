package com.example.nutralysis2.View

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.FragmentMainBinding
import com.example.nutralysis2.model.analyisiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.onCompletion

@AndroidEntryPoint
class MainFrag : Fragment() {
    lateinit var navController: NavController
    private lateinit var binding: FragmentMainBinding
    val viewModel: analyisiViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        binding.tvIngredients.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, after: Int) {
                p0?.let {
                    viewModel.onIngredientsChanged(it)
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        viewModel.isSubmitButtonEnabled.observe(viewLifecycleOwner) {
            binding.button.isEnabled = it
        }

        binding.button.setOnClickListener {

            viewModel.getNutrents(binding.tvIngredients.text.toString())
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        viewModel.isNutrientsAnalysed.observe(viewLifecycleOwner) {
            viewModel.isNutrientsAnalysed.removeObservers(viewLifecycleOwner)
            navController.navigate(R.id.action_mainFrag_to_incredientListFragment)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentMainBinding.inflate(inflater, container, false)

        return binding.root

    }


}