package com.example.wordict

import android.app.ActionBar
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val pos = intent.getIntExtra("id",-1)

        if(pos!=-1){
            val word = DataObject.getWord(pos).word
            val meaning = DataObject.getWord(pos).meaning
            val sentence = DataObject.getWord(pos).sentence
            val placeOfEncounter = DataObject.getWord(pos).placeOfEncounter
            val synonyms = DataObject.getWord(pos).synonyms

            word_holder.setText(word)
            meaning_holder.setText(meaning)
            sentence_holder.setText(sentence)
            place_of_encounter_holder.setText(placeOfEncounter)
            synonyms_holder.setText(synonyms)

            edit_word.setOnClickListener {
                val intent = Intent(this,UpdateCard::class.java)
                intent.putExtra("id",pos)
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}