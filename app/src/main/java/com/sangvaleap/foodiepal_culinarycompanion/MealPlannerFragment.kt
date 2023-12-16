package com.sangvaleap.foodiepal_culinarycompanion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MealPlannerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.fab)
        btnAdd.setOnClickListener {
            println("MealPlannerFragment added")
            MealPlannerInputDialog( requireContext(), object : MealPlannerInputDialog.OnSubmitClickListener{
                override fun onSubmit(title: String) {
                    Toast.makeText(context, "Title: $title", Toast.LENGTH_SHORT).show()
                }

            } ).show(parentFragmentManager, "mealPlannerInputDialog")
        }
        return view;
    }

}