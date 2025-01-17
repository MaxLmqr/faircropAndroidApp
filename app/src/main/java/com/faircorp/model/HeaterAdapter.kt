package com.faircorp.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faircorp.R

// Adapter to fill the heater recycler from a list of heaters object.
class HeaterAdapter : RecyclerView.Adapter<HeaterAdapter.HeaterViewHolder>() {
    inner class HeaterViewHolder(view: View) : RecyclerView.ViewHolder(view) { // (2)
        val name: TextView = view.findViewById(R.id.txt_heater_name)
        val power: TextView = view.findViewById(R.id.txt_heater_power)
        val status: TextView = view.findViewById(R.id.txt_heater_status)
    }

    private val items = mutableListOf<HeaterDto>() // (3)

    fun update(heaters: List<HeaterDto>) {  // (4)
        items.clear()
        items.addAll(heaters)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size // (5)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaterViewHolder { // (6)
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_heaters_item, parent, false)
        return HeaterViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaterViewHolder, position: Int) {  // (7)
        val heater = items[position]
        holder.apply {
            name.text = heater.name
            status.text = heater.heaterStatus.toString()
            power.text = heater.power.toString()
            //itemView.setOnClickListener { listener.onWindowSelected(heater.id)}
        }
    }

    override fun onViewRecycled(holder: HeaterViewHolder) { // (2)
        super.onViewRecycled(holder)
        holder.apply {
            //itemView.setOnClickListener(null)
        }

    }
}