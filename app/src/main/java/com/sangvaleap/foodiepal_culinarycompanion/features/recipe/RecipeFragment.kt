package com.sangvaleap.foodiepal_culinarycompanion.features.recipe

import android.content.Context
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
import com.sangvaleap.foodiepal_culinarycompanion.model.Recipe

class RecipeFragment : Fragment() {

    private var recipeList: ArrayList<Recipe> = arrayListOf(
        Recipe("A", "a b c", "test", ""),
        Recipe("B", "a b c d", "test2", ""),
        Recipe("C", "a b c e", "test3", ""),
        Recipe("D", "a b c f", "test4", ""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val context = requireContext()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.fab)
        btnAdd.setOnClickListener {
            onAdd(context)
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvRecipe)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecipeAdapter(requireContext(), recipeList)

        return view;
    }

    private fun onAdd(context: Context){
        println("added")
        val inputDialog = RecipeInputDialog(context, object : RecipeInputDialog.OnSubmitClickListener {
            override fun onSubmit(
                recipeName: String,
                ingredients: String,
                instruction: String
            ) {
                Toast.makeText(context, "Name: $recipeName, ingredients: $ingredients, instruction: $instruction", Toast.LENGTH_SHORT).show()
            }
        })
        inputDialog.show()
    }

}