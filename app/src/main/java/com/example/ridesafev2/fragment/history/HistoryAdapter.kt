package com.example.ridesafev2.fragment.history

import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location
import com.example.ridesafev2.fragment.update.Update

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    private var locationList = emptyList<Location>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_row,
                parent,
                false)
        )
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = locationList[position]

        holder.itemView.findViewById<TextView>(R.id.current_txt).text = currentItem.start_location
        holder.itemView.findViewById<TextView>(R.id.destination_txt).text = currentItem.end_location
        holder.itemView.findViewById<TextView>(R.id.current_txt).text = currentItem.close_encounters.toString()
        holder.itemView.findViewById<TextView>(R.id.destination_txt).text = currentItem.adventureTime.toString()

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener{
            val action =
        }
    }

    fun setData(location: List<Location>) {
        this.locationList = location
        notifyDataSetChanged()
    }
}