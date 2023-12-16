package com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.model.MealPlanner
import com.sangvaleap.foodiepal_culinarycompanion.model.Recipe

class MealPlannerAdapter(private var context: Context, private var itemList: List<MealPlanner>): RecyclerView.Adapter<MealPlannerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.tvMPDay)
        val meal: TextView = itemView.findViewById(R.id.tvMPMeal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.meal_planner_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = itemList[position].day
        holder.meal.text = itemList[position].meal

    }
}