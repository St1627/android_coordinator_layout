package com.example.coordinator.cases

import TestAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class SetRecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    fun onCreated(recyclerView: RecyclerView, biggerPadding: Boolean, dataCounts:Int) {
        this.recyclerView = recyclerView
        this.recyclerView.layoutManager = LinearLayoutManager(this)
        val data: MutableList<String> = mutableListOf()
        for (i in 0..dataCounts) {
            data.add("Data $i")
        }
        val adapter: TestAdapter = TestAdapter(biggerPadding)
        this.recyclerView.adapter = adapter
        adapter.setData(data)
    }

}