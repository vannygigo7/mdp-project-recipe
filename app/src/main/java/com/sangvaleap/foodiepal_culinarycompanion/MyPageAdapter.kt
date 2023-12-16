package com.sangvaleap.foodiepal_culinarycompanion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sangvaleap.foodiepal_culinarycompanion.features.about.AboutMeFragment
import com.sangvaleap.foodiepal_culinarycompanion.features.blog.BlogFragment
import com.sangvaleap.foodiepal_culinarycompanion.features.contact.ContactFragment
import com.sangvaleap.foodiepal_culinarycompanion.features.meal_planner.MealPlannerFragment
import com.sangvaleap.foodiepal_culinarycompanion.features.recipe.RecipeFragment

class MyPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount()  = 5

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> RecipeFragment()
            1 -> MealPlannerFragment()
            2 -> BlogFragment()
            3 -> ContactFragment()
            4 -> AboutMeFragment()
            else -> Fragment()
        }
    }
}