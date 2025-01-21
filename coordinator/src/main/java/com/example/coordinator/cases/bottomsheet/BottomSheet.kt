package com.example.coordinator.cases.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import com.example.coordinator.cases.SetRecyclerViewActivity
import com.example.coordinator.databinding.ActivityBottomSheetBehaviorBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheet : SetRecyclerViewActivity() {

    private lateinit var binding: ActivityBottomSheetBehaviorBinding
    private lateinit var behavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBottomSheetBehaviorBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        onCreated(binding.recyclerview, true, 25)
        behavior = BottomSheetBehavior.from(binding.bottomSheet)
        behavior.isHideable = true
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
        behavior.peekHeight = Math.round(resources.displayMetrics.density * 50)
        binding.fab.setOnClickListener {
            triggerToNextState(behavior)
        }
    }

    fun triggerToNextState(current:BottomSheetBehavior<LinearLayout>){
        when(current.state){
            BottomSheetBehavior.STATE_DRAGGING -> return
            BottomSheetBehavior.STATE_SETTLING -> return
            BottomSheetBehavior.STATE_HIDDEN -> current.state = BottomSheetBehavior.STATE_EXPANDED
            BottomSheetBehavior.STATE_EXPANDED -> current.state = BottomSheetBehavior.STATE_HALF_EXPANDED
            BottomSheetBehavior.STATE_HALF_EXPANDED -> current.state = BottomSheetBehavior.STATE_COLLAPSED
            BottomSheetBehavior.STATE_COLLAPSED -> current.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}