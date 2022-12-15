package com.example.ridesafe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ridesafev2.HistoryAdapter
import com.example.ridesafev2.HistoryData
import com.example.ridesafev2.R
import com.example.ridesafev2.databinding.RsFragAboutBinding

class History : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private var historyList = ArrayList<HistoryData>()
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rs_frag_history)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = HistoryAdapter(historyList)
        recyclerView.adapter = adapter

    }

    private fun addDataToList() {
        historyList.add(
            HistoryData(
                "What is ridesafe?",
                "Lorem ipsum blah blah blah"
            )
        )
    }
}
