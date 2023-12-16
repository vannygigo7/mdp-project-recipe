package com.sangvaleap.foodiepal_culinarycompanion.features.blog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.sangvaleap.foodiepal_culinarycompanion.R

class BlogPostInputDialog(context: Context, private val listener: OnSubmitClickListener): DialogFragment() {
    interface OnSubmitClickListener {
        fun onSubmit(day: String, meal: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.blog_post_input_dailog, container, false)

        val caption = view.findViewById<EditText>(R.id.etCaption)
        val content = view.findViewById<EditText>(R.id.etContent)
        val btnAdd = view.findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener { onAdd(caption.text.toString(), content.text.toString()) }
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

    private fun onAdd(caption: String, content: String){
        if(!validateForm(caption, content)) return
        listener.onSubmit(caption, content)
        dismiss()
    }


    private fun validateForm(caption: String, content: String): Boolean{
        return !( caption.isEmpty() || content.isEmpty())
    }
}