package com.sangvaleap.foodiepal_culinarycompanion.features.about

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sangvaleap.foodiepal_culinarycompanion.LoginActivity
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.RegisterActivity
import com.sangvaleap.foodiepal_culinarycompanion.features.blog.BlogPostInputDialog
import com.sangvaleap.foodiepal_culinarycompanion.model.BlogPost
import com.sangvaleap.foodiepal_culinarycompanion.utils.AppConstants

class AboutMeFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)

        val btnAdd = view.findViewById<FloatingActionButton>(R.id.fab)
        btnAdd.setOnClickListener {
            onSave(view)
        }

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            onLogout()
        }

        return  view
    }

    private fun onSave(view: View){
        AboutMeInputDialog( requireContext(), object : AboutMeInputDialog.OnSubmitClickListener{
            override fun onSubmit(journey: String, favRecipes: String, foodPhilosophy: String) {
                val tvJourney = view.findViewById<TextView>(R.id.tvJourney)
                val tvFavRecipes = view.findViewById<TextView>(R.id.tvFavRecipes)
                val tvPhilosophy = view.findViewById<TextView>(R.id.tvFoodPhilosophy)
                tvJourney.text = journey.ifEmpty { tvJourney.text }
                tvFavRecipes.text = favRecipes.ifEmpty { tvFavRecipes.text }
                tvPhilosophy.text = foodPhilosophy.ifEmpty { tvPhilosophy.text }
                Toast.makeText(context, "Your details was updated", Toast.LENGTH_SHORT).show()
            }
        } ).show(parentFragmentManager, "AboutMeInputDialog")
    }

    private fun onLogout(){
//        removeUserPreference()
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        requireActivity().finish()
    }

    private fun removeUserPreference(){
        val prefs = requireContext().getSharedPreferences(
            AppConstants.USER_PREFERENCE,
            AppCompatActivity.MODE_PRIVATE
        ).edit()
         prefs.remove(AppConstants.USER)
        prefs.apply()
    }
}