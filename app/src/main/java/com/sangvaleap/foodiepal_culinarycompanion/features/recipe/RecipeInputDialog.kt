package com.sangvaleap.foodiepal_culinarycompanion.features.recipe

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.sangvaleap.foodiepal_culinarycompanion.R

class RecipeInputDialog(context: Context, private val listener: OnSubmitClickListener) : Dialog(context) {

    interface OnSubmitClickListener {
        fun onSubmit(recipeName: String, ingredients: String, instruction: String)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_input_dialog)

        val recipeName: EditText = findViewById(R.id.etRecipeName)
        val ingredients: EditText = findViewById(R.id.etIngredients)
        val instruction: EditText = findViewById(R.id.etInstruction)
        val btnAdd: Button = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val name = recipeName.text.toString()
            val ingredients = ingredients.text.toString()
            val instruction = instruction.text.toString()
            onAdd(name, ingredients, instruction)
        }
    }

    private fun onAdd(recipeName: String, ingredients: String, instruction: String){
        listener.onSubmit(recipeName, ingredients, instruction)
        dismiss()
    }
}
