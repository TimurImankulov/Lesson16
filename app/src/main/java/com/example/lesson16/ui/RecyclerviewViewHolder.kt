package com.example.lesson16.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson16.data.DataClass
import kotlinx.android.synthetic.main.item_rv.view.*

class RecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        item: DataClass
    ) {
        itemView.tvTitle.text = item.etTitle
        itemView.tvDesc.text = item.etDesc
    }
}