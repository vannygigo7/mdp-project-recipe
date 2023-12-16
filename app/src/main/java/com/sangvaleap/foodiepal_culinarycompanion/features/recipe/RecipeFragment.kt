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
        Recipe("Spaghetti Bologna", """
            1 lb ground beef
            1 onion, finely chopped 
            2 cloves garlic, minced
            """.trimIndent(), "In a large skillet, brown the ground beef over medium heat. Drain excess fat.", ""),
        Recipe("Chicken Caesar Salad", """
            2 boneless, skinless chicken breasts 
            Salt and pepper to taste 
            1 tbsp olive oil
            """.trimIndent(), "Season chicken breasts with salt and pepper. In a skillet, heat olive oil over medium-high heat.", ""),
        Recipe("Vegetarian Quinoa Stir-Fry", """
            1 cup quinoa, rinsed and cooked 
            2 tbsp soy sauce 
            1 tbsp sesame oil
            """.trimIndent(), "In a wok or large skillet, heat sesame oil over medium-high heat.", ""),
        Recipe("Vegetarian Chickpea Curry", """
            2 cans (15 oz each) chickpeas, drained and rinsed 
            1 onion, finely chopped 
            2 cloves garlic, minced
        """.trimIndent(), "In a large skillet, sauté the chopped onion and garlic until softened.", ""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.fab)
        btnAdd.setOnClickListener {
            onAdd()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvRecipe)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecipeAdapter(requireContext(), recipeList)

        return view;
    }

    private fun onAdd(){
        RecipeInputDialog(requireContext(), object : RecipeInputDialog.OnSubmitClickListener {
            override fun onSubmit(
                recipeName: String,
                ingredients: String,
                instruction: String
            ) {
                recipeList.add(Recipe(recipeName, ingredients, instruction, ""))
                Toast.makeText(context, "New recipe was added", Toast.LENGTH_SHORT).show()
            }
        }).show()
    }

}