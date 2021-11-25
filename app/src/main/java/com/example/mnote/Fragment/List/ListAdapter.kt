package com.example.mnote.Fragment.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mnote.R
import com.example.mnote.model.User
import kotlinx.android.synthetic.main.custom_layout.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var textList = emptyList<User>()

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = textList[position]
        holder.itemView.apply {
            title_list.text = currentItem.title
            lable_list.text = currentItem.label
            text_list.text = currentItem.body
        }
    }

    override fun getItemCount(): Int {
        return textList.size
    }

    fun setData(text : List<User>){
        this.textList = text
        notifyDataSetChanged()
    }
}