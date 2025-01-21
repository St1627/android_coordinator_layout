package com.example.coordinator.cases.layout_anchor

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import com.example.coordinator.cases.SetRecyclerViewActivity
import com.example.coordinator.databinding.ActivityFloatingActionButtonBinding
import com.google.android.material.snackbar.Snackbar

class FloatingActionButton : SetRecyclerViewActivity() {

    private lateinit var binding: ActivityFloatingActionButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFloatingActionButtonBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        onCreated(binding.recyclerview, true, 25)
        binding.fab.setOnClickListener {
            Snackbar.make(binding.root, "Test", 3000).show()
        }
    }
}