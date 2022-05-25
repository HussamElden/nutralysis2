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
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nutralysis2.R
import com.example.nutralysis2.model.analyisiViewModel
import com.example.nutralysis2.model.analysisViewModelFactory
import com.example.nutralysis2.model.nutrationRepo
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*


class MainFrag : Fragment() {
    var navController: NavController?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        view.tvIngredients.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, after: Int) {
                if (after== 0){
                    view.button.setEnabled(false);
                }else{
                    view.button.setEnabled(true);
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        view.button.setOnClickListener {
            if(!TextUtils.isEmpty(tvIngredients.text.toString())){
                Log.d("test", tvIngredients.text.toString())
                val bundle = bundleOf("ingredients" to tvIngredients.text.toString() )
                navController!!.navigate(R.id.action_mainFrag_to_incredientListFragment,bundle)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


}