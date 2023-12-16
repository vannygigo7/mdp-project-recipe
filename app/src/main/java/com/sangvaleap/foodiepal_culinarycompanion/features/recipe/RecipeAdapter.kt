package com.sangvaleap.foodiepal_culinarycompanion.features.recipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.model.Recipe

class RecipeAdapter(private var context: Context, private var itemList: List<Recipe>): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvRecipeName)
        val ingredients: TextView = itemView.findViewById(R.id.tvIngredients)
        val instruction: TextView = itemView.findViewById(R.id.tvInstruction)
        val image: ImageView = itemView.findViewById(R.id.imgRecipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.ingredients.text = itemList[position].ingredients
        holder.instruction.text = itemList[position].instruction

    }
}