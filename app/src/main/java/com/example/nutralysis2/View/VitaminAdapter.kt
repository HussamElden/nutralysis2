package com.example.nutralysis2.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutralysis2.R
import com.example.nutralysis2.databinding.IngredientDetailsBinding
import com.example.nutralysis2.databinding.VitamnListItemBinding

import kotlin.math.roundToInt

class VitaminAdapter(var items:List<List<String>>): RecyclerView.Adapter<VitaminAdapter.VitaminViewHolder>() {

    inner class VitaminViewHolder(val binding: VitamnListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VitaminAdapter.VitaminViewHolder {
        return  VitaminViewHolder(
            VitamnListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: VitaminAdapter.VitaminViewHolder, position: Int) {
        holder.binding.apply {
            val curVitamin = items[position]
            tvLabel.text = curVitamin[0]
            tvQuantity.text =
                ((curVitamin[1]?.toDouble() * 100.0).roundToInt() / 100.0).toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}