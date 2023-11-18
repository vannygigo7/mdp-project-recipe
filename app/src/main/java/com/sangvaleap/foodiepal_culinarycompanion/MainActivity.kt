package com.sangvaleap.foodiepal_culinarycompanion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sangvaleap.foodiepal_culinarycompanion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vpager.adapter = MyPageAdapter(this)
        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tlayout, binding.vpager){
            tab, position ->
            when(position){
                0 -> {
                    tab.text = "Recipe"
                }
                1->{
                    tab.text = "Meal Planner"
                }
                2 -> {
                    tab.text ="Blog"
                }
                3 -> {
                    tab.text ="Contact"
                }
                4 -> {
                    tab.text ="About"
                }
            }
        }.attach()
    }
}