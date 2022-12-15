package com.example.ridesafev2.fragment.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ridesafev2.R
import com.example.ridesafev2.data.database.Location

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
    }

    fun setData(location: List<Location>) {
        this.locationList = location
        notifyDataSetChanged()
    }
}