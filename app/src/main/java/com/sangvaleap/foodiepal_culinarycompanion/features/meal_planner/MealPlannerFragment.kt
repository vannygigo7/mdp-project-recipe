package com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.model.MealPlanner

class MealPlannerFragment : Fragment() {
    private var mealPlanList: ArrayList<MealPlanner> = arrayListOf(
        MealPlanner("Monday", """
            Breakfast: bread and milk
            Lunch: noodle and coffee""".trimIndent()),
        MealPlanner("Tuesday", """
            Breakfast: bread and milk
            Lunch: noodle and coffee
            Dinner: salad and milk
        """.trimIndent()),
    )
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
            onAdd()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvMealPlanner)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MealPlannerAdapter(requireContext(), mealPlanList)

        return view;
    }

    private fun onAdd(){
        MealPlannerInputDialog( requireContext(), object : MealPlannerInputDialog.OnSubmitClickListener{
            override fun onSubmit(day: String, meal: String) {
                mealPlanList.add(MealPlanner(day, meal))
                Toast.makeText(context, "New meal plan was added", Toast.LENGTH_SHORT).show()
            }

        } ).show(parentFragmentManager, "MealPlannerInputDialog")
    }

}