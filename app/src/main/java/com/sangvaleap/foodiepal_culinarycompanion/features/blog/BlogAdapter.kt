package com.sangvaleap.foodiepal_culinarycompanion.features.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sangvaleap.foodiepal_culinarycompanion.R
import com.sangvaleap.foodiepal_culinarycompanion.model.BlogPost

class BlogAdapter(val context: Context, private val itemList: List<BlogPost>): RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val caption: TextView = itemView.findViewById(R.id.tvCaption)
        val dateTime: TextView = itemView.findViewById(R.id.tvDateTime)
        val content: TextView = itemView.findViewById(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.caption.text = itemList[position].caption
        holder.dateTime.text = itemList[position].dateTime
        holder.content.text = itemList[position].content

    }
}