package com.example.testable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


interface OnInteractionalListener{
    fun onClickItem(data: Int, position: Int)
}

class ListAdapter(
    private val listener: OnInteractionalListener,
    private val list : MutableList<Int>
): RecyclerView.Adapter<ListAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val resId = R.layout.main_view_holder
        val view = LayoutInflater.from(parent.context).inflate(resId, parent, false)
        return MainViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    class MainViewHolder(
        view: View,
        val listener: OnInteractionalListener
    ): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.main_data)

        fun bind(data: Int, position: Int){
            textView.text = data.toString()
            textView.setOnClickListener { listener.onClickItem(data, position) }
        }
    }
}