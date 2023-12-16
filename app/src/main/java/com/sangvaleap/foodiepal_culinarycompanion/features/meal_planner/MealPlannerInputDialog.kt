package com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.sangvaleap.foodiepal_culinarycompanion.R

class MealPlannerInputDialog(context: Context, private val listener: OnSubmitClickListener): DialogFragment() {
    interface OnSubmitClickListener {
        fun onSubmit(day: String, meal: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.meal_planner_input_dailog, container, false)

        val day = view.findViewById<EditText>(R.id.etDay)
        val meal = view.findViewById<EditText>(R.id.etDay)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener { onAdd(day.text.toString(), day.text.toString()) }
        return  view;
    }

    override fun onStart() {
        super.onStart()

        // Set dialog width and height to match parent (full-screen)
//        dialog?.window?.setLayout(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
    }

    private fun onAdd(day: String, meal: String){
        listener.onSubmit(day, meal)
        dismiss()
    }
}