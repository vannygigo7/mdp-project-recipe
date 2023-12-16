package com.sangvaleap.foodiepal_culinarycompanion

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecipeFragment : Fragment() {
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