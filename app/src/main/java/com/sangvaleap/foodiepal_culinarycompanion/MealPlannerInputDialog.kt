package com.sangvaleap.foodiepal_culinarycompanion

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MealPlannerInputDialog(context: Context, private val listener: MealPlannerInputDialog.OnSubmitClickListener): DialogFragment() {
    interface OnSubmitClickListener {
        fun onSubmit(title: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.meal_planner_input_dailog, container, false)

        val title = view.findViewById<EditText>(R.id.etTitle)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener { onAdd(title.text.toString()) }
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

    private fun onAdd(title: String){
        listener.onSubmit(title)
        dismiss()
    }
}