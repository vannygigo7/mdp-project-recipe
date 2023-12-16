package com.sangvaleap.foodiepal_culinarycompanion.features.blog

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner.MealPlannerAdapter
import com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner.MealPlannerInputDialog
import com.sangvaleap.foodiepal_culinarycompanion.model.BlogPost
import com.sangvaleap.foodiepal_culinarycompanion.model.MealPlanner
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class BlogFragment : Fragment() {
    private var postList: ArrayList<BlogPost> = arrayListOf(
        BlogPost("Pizza night perfection! \uD83C\uDF55", "Crafted a homemade Margherita pizza with fresh mozzarella, tomatoes, and basil. The aroma alone is pure happiness.", "12/01/2023 08:40 PM"),
        BlogPost("Fueling up for the day ahead!", "Starting the morning with a nutrient-packed bowl: Greek yogurt, granola, mixed berries, and a drizzle of honey. What's your go-to breakfast? ", "11/11/2023 03:30 PM"),
        BlogPost("Soul-soothing goodness in a bowl!", "Homemade chicken noodle soup loaded with veggies. Perfect for cozy nights and fighting off the winter chill.", "10/115/2023 04:30 PM"),
        BlogPost("Freshly baked happiness! \uD83C\uDF6A", "Satisfying the sweet tooth with warm, gooey chocolate chip cookies. Who can resist the aroma of freshly baked treats?", "9/20/2023 11:30 PM"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.fab)
        btnAdd.setOnClickListener {
            onAdd()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvBlog)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = BlogAdapter(requireContext(), postList)

        return  view
    }

    private fun onAdd(){
        BlogPostInputDialog( requireContext(), object : BlogPostInputDialog.OnSubmitClickListener{
            override fun onSubmit(caption: String, content: String) {
                postList.add(BlogPost(caption, content, getCurrentDateTime()))
                Toast.makeText(context, "New post was added", Toast.LENGTH_SHORT).show()
            }
        } ).show(parentFragmentManager, "BlogPostInputDialog")
    }

    private fun getCurrentDateTime() :String{
        val currentDate = Date()
        val formatter = SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.getDefault())
        return formatter.format(currentDate)
    }

}