package com.example.nutralysis2.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutralysis2.R
import com.example.nutralysis2.entities.Ingredient
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.ingredient_details.view.*
import kotlin.math.roundToInt

class IngredientsAdapter(var items:List<Ingredient>): RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>()  {
    inner class IngredientsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ingredient_details,parent,false)
        return IngredientsViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val curIngredient =items[position]
        holder.itemView.tvIngredientTitle.text=curIngredient.text
        holder.itemView.tvIngredientCalories.text=  ((curIngredient.parsed[0].nutrients.ENERC_KCAL.quantity * 100.0).roundToInt() / 100.0).toString()
        holder.itemView.tvIngredientQuantity.text=((curIngredient.parsed[0].quantity).roundToInt() / 100.0).toString()
        holder.itemView.tvIngredientFood.text= curIngredient.parsed[0].food
        holder.itemView.tvIngredientUnit.text= "g"
        holder.itemView.tvIngredientWeight.text= ((curIngredient.parsed[0].weight * 100.0).roundToInt() / 100.0).toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}