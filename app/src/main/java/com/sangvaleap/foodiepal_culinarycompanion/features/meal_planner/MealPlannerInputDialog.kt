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
        val meal = view.findViewById<EditText>(R.id.etMeal)

        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            onAdd(day.text.toString(), meal.text.toString())
        }

        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            dismiss()
        }

        return  view;
    }

    override fun onStart() {
        super.onStart()
    }

    private fun onAdd(day: String, meal: String){
        if(!validateForm(day, meal)) return
        listener.onSubmit(day, meal)
        dismiss()
    }

    private fun validateForm(day: String, meal: String): Boolean{
       return !(day.isEmpty() || meal.isEmpty())
    }
}