package com.example.wordict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        add_word.setOnClickListener {
            val intent = Intent(this, CreateCard::class.java)
            startActivity(intent)
        }

        setRecyclerView()
    }

    fun setRecyclerView(){
        if(DataObject.size()!=0) {
            recycler_view.adapter = ItemAdapter(DataObject.getAllData())
            recycler_view.layoutManager = LinearLayoutManager(this)
            empty_view.isVisible = false
        } else{
            empty_view.isVisible = true
            recycler_view.isVisible = false
        }
    }
}