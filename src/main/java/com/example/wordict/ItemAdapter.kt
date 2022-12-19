package com.example.wordict

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_create_card.view.*
import kotlinx.android.synthetic.main.activity_create_card.view.meaning
import kotlinx.android.synthetic.main.activity_create_card.view.place_of_encounter
import kotlinx.android.synthetic.main.activity_create_card.view.sentence
import kotlinx.android.synthetic.main.activity_create_card.view.synonyms
import kotlinx.android.synthetic.main.activity_create_card.view.word
import kotlinx.android.synthetic.main.activity_item_detail.view.*
import kotlinx.android.synthetic.main.view.view.*

class ItemAdapter(var data: List<CardInfo>):RecyclerView.Adapter<ItemAdapter.viewHolder>() {
    class viewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var word = itemView.word_text_view
        var meaning = itemView.meaning_text_view
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)

        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.word.text = data[position].word
        holder.meaning.text = data[position].meaning

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,ItemDetail::class.java)
            intent.putExtra("id",position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}