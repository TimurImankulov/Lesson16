package com.example.lesson16.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson16.R
import com.example.lesson16.data.DataClass

class RecyclerviewAdapter(): RecyclerView.Adapter<RecyclerviewViewHolder>() {

    private var data = arrayListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return RecyclerviewViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun update(data: List<DataClass>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}
