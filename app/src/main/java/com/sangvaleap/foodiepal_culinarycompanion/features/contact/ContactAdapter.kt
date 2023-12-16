package com.sangvaleap.foodiepal_culinarycompanion.features.contact

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.model.ChefContact
import com.sangvaleap.foodiepal_culinarycompanion.utils.AppIntents

class ContactAdapter(val context: Context, private val itemList: List<ChefContact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvChefName)
        val phone: TextView = itemView.findViewById(R.id.tvPhone)
        val email: TextView = itemView.findViewById(R.id.tvEmail)
    }

    private fun setClickAbleTextView(textView: TextView, label: String, value: String, action: ()->Unit){

        val spannableString = SpannableString("$label: $value")

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                action()
            }
        }
        spannableString.setSpan(clickableSpan, label.length + 2, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.chef_contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = itemList[position].name
        val phone = itemList[position].phone
        val email = itemList[position].email
        holder.name.text = name
        holder.phone.text = phone
        holder.email.text = email

        setClickAbleTextView(holder.phone, "phone",phone, fun(){
            AppIntents.getInstance(context).startDialPhone(phone)
        })
        setClickAbleTextView(holder.email, "email", email, fun(){
            AppIntents.getInstance(context).startEmail(email)
        })
    }
}