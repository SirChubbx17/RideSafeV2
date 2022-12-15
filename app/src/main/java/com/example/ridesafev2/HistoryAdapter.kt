package com.example.ridesafev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private var historyList: List<HistoryData>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>(){

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var route1txt : TextView = itemView.findViewById(R.id.route1)
        var route2txt : TextView = itemView.findViewById(R.id.route2)
        var dsttxt : TextView = itemView.findViewById(R.id.dst)
        var constraintLayout : ConstraintLayout = itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rs_frag_historyrow, parent, false)
        return HistoryViewHolder(view)

    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyData = historyList[position]
        holder.route1txt.text = historyData.start
        holder.route2txt.text = historyData.end
        holder.dsttxt.text = historyData.distance
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}