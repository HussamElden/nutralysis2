package com.example.nutralysis2.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nutralysis2.R
import com.example.nutralysis2.entities.Ingredient
import kotlinx.android.synthetic.main.vitamn_list_item.view.*
import kotlin.math.roundToInt

class VitaminAdapter(var items:List<List<String>>): RecyclerView.Adapter<VitaminAdapter.VitaminViewHolder>() {

    inner class VitaminViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VitaminAdapter.VitaminViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vitamn_list_item,parent,false)
        return VitaminViewHolder(view)
    }

    override fun onBindViewHolder(holder: VitaminAdapter.VitaminViewHolder, position: Int) {
        val curVitamin =items[position]
        holder.itemView.tvLabel.text = curVitamin[0]
        holder.itemView.tvQuantity.text = ((curVitamin[1].toDouble() * 100.0).roundToInt() / 100.0).toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}