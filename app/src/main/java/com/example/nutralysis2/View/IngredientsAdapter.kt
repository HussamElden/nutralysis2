package com.example.nutralysis2.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.IngredientDetailsBinding
import com.example.nutralysis2.entities.Ingredient

import kotlin.math.roundToInt

class IngredientsAdapter(var items:List<Ingredient>): RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>()  {
    inner class IngredientsViewHolder(val binding: IngredientDetailsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        return  IngredientsViewHolder(IngredientDetailsBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.binding.apply {
            val curIngredient = items[position]
            tvIngredientTitle.text = curIngredient.text
           tvIngredientCalories.text =
                ((curIngredient.parsed[0].nutrients.ENERC_KCAL?.quantity * 100.0).roundToInt() / 100.0).toString()
            tvIngredientQuantity.text =
                ((curIngredient.parsed[0]?.quantity).roundToInt() / 100.0).toString()
            tvIngredientFood.text = curIngredient.parsed[0]?.food
            tvIngredientUnit.text = "g"
            tvIngredientWeight.text =
                ((curIngredient.parsed[0]?.weight * 100.0).roundToInt() / 100.0).toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}