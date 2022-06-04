package com.example.nutralysis2.View

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
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
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.FragmentMainBinding
import com.example.nutralysis2.databinding.FragmentTotalNutrientsBinding
import com.example.nutralysis2.model.analyisiViewModel
import com.example.nutralysis2.model.analysisViewModelFactory
import com.example.nutralysis2.model.nutrationRepo
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFrag : Fragment() {
    var navController: NavController? = null
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
                binding.button.setEnabled(viewModel.isButtonDisplayed(after))

            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding.button.setOnClickListener {
            if (!TextUtils.isEmpty(binding.tvIngredients.text.toString())) {
                binding.progressBar.isVisible = true
                viewModel.test = "first"
                viewModel.allObjLiveData.observe(viewLifecycleOwner, Observer {
                    navController!!.navigate(R.id.action_mainFrag_to_incredientListFragment)
                })

                CoroutineScope(Dispatchers.Main).launch {

                    viewModel.getNutrents(binding.tvIngredients.text.toString())
                    binding.progressBar.isVisible = false
                }
//
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentMainBinding.inflate(inflater, container, false)

        return binding.root

    }


}