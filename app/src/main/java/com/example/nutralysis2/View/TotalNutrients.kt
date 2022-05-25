package com.example.nutralysis2.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nutralysis2.R
import com.example.nutralysis2.entities.nutrentanalysis
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

@SuppressLint("UseRequireInsteadOfGet")
class TotalNutrients : Fragment() {
    lateinit var analysisData:nutrentanalysis
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gson = Gson()
        val json = arguments!!.get("analysisData") as String
        Log.d("resdata",json)
        analysisData = gson.fromJson("{"+json+"}",nutrentanalysis::class.java)
        Log.d("data",analysisData.toString())

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
    }
}