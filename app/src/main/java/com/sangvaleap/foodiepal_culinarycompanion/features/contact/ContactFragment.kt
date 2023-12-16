package com.sangvaleap.foodiepal_culinarycompanion.features.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.features.blog.BlogAdapter
import com.sangvaleap.foodiepal_culinarycompanion.model.BlogPost
import com.sangvaleap.foodiepal_culinarycompanion.model.ChefContact

class ContactFragment : Fragment() {

    private var chefContactList: ArrayList<ChefContact> = arrayListOf(
        ChefContact("Mr. Nani", "1234567890", "nani@test.com"),
        ChefContact("Mrs. Priya", "2345678901", "priya@test.com"),
        ChefContact("Mr. Carlos", "3456789012", "carlos@test.com"),
        ChefContact("Ms. Borica", "4567890123", "brica@test.com"),
       )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvContact)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ContactAdapter(requireContext(), chefContactList)

        return view;
    }


}