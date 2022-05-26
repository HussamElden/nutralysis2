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
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nutralysis2.R
import com.example.nutralysis2.entities.nutrentanalysis
import com.example.nutralysis2.model.analyisiViewModel
import com.example.nutralysis2.model.analysisViewModelFactory
import com.example.nutralysis2.model.nutrationRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_incredient_list.*
import kotlinx.android.synthetic.main.fragment_main.*


class IncredientListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var ingredients:List<String>
    var navController: NavController?=null
    lateinit var analysisData: nutrentanalysis
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ingredients = arguments!!.getString("ingredients").toString().split("\n")



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = nutrationRepo
        val factory = analysisViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(analyisiViewModel::class.java)

        val adapter = IngredientsAdapter(listOf())
        navController= Navigation.findNavController(view)

        rvIngredients.layoutManager = LinearLayoutManager(this.context)
        rvIngredients.adapter = adapter

        viewModel.allObjLiveData.observe(viewLifecycleOwner, Observer {


            if (it.ingredients !=  null){
                adapter.items=it.ingredients
                adapter.notifyDataSetChanged()
                analysisData = it
            }
            progressBar.isVisible = false
            BTTotal.isVisible = true
        })
        viewModel.getNutrents(ingredients)
        BTTotal.setOnClickListener {
            if(analysisData != null){
                val gson = Gson()


                val jsonTut: String = gson.toJson(analysisData)
                val bundle = bundleOf("analysisData" to jsonTut )
                navController!!.navigate(R.id.action_incredientListFragment_to_totalNutrients,bundle)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incredient_list, container, false)
    }


}