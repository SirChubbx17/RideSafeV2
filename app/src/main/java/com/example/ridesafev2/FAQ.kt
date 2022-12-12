package com.example.ridesafev2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FAQ : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private var faqList = ArrayList<FAQData>()
    private lateinit var adapter: FAQAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rs_frag_faq)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = FAQAdapter(faqList)
        recyclerView.adapter = adapter

    }

    private fun addDataToList() {
        faqList.add(
            FAQData(
                "What is ridesafe?",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Est placerat in egestas erat. Semper feugiat nibh sed pulvinar proin gravida hendrerit. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed velit. Enim nulla aliquet porttitor lacus luctus accumsan."
            )
        )
        faqList.add(
            FAQData(
                "How to user ridesafe?",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
        )
        faqList.add(
            FAQData(
                "Fix a map issue",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
        )
    }
}