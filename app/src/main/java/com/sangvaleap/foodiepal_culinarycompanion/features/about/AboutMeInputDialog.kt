package com.sangvaleap.foodiepal_culinarycompanion.features.about

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.sangvaleap.foodiepal_culinarycompanion.R

class AboutMeInputDialog(context: Context, private val listener: OnSubmitClickListener): DialogFragment() {
    interface OnSubmitClickListener {
        fun onSubmit(journey: String, favRecipes: String, foodPhilosophy: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.about_me_input_dialog, container, false)

        val journey = view.findViewById<EditText>(R.id.etJourney)
        val favRecipes = view.findViewById<EditText>(R.id.etFavRecipes)
        val foodPhilosophy = view.findViewById<EditText>(R.id.etFoodPhilosophy)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener { onAdd(journey.text.trim().toString(), favRecipes.text.trim().toString(), foodPhilosophy.text.trim().toString()) }
        return  view;
    }

    override fun onStart() {
        super.onStart()

        // Set dialog width and height to match parent (full-screen)
//        dialog?.window?.setLayout(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
    }

    private fun onAdd(journey: String, favRecipes: String, foodPhilosophy: String){
        if(!validateForm(journey, favRecipes, foodPhilosophy)) return
        listener.onSubmit(journey, favRecipes, foodPhilosophy)
        dismiss()
    }

    private fun validateForm(journey: String, favRecipes: String, foodPhilosophy: String): Boolean{
        return ( journey.isNotEmpty() || favRecipes.isNotEmpty() || foodPhilosophy.isNotEmpty())
    }
}