package com.example.wordict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val database:myDatabase by lazy{
            myDatabase.getDatabase(this)
        }

        val pos = intent.getIntExtra("id",-1)
        if(pos!=-1){
            val word = DataObject.getWord(pos).word
            val meaning = DataObject.getWord(pos).meaning
            val sentence = DataObject.getWord(pos).sentence
            val placeOfEncounter = DataObject.getWord(pos).placeOfEncounter
            val synonyms = DataObject.getWord(pos).synonyms

            word_updated.setText(word)
            meaning_updated.setText(meaning)
            sentence_updated.setText(sentence)
            place_of_encounter_updated.setText(placeOfEncounter)
            synonyms_updated.setText(synonyms)

            delete_button.setOnClickListener {
                DataObject.deleteWord(pos)
                GlobalScope.launch {
                    database.dao().deleteWord(Entity(pos+1,word_updated.text.toString(),meaning_updated.text.toString(),
                    sentence_updated.text.toString(),place_of_encounter_updated.text.toString(),synonyms_updated.text.toString()))
                }
                myIntent()
            }

            update_button.setOnClickListener {
                DataObject.updateItem(pos,word_updated.text.toString(),meaning_updated.text.toString(),
                    sentence_updated.text.toString(),place_of_encounter_updated.text.toString(),synonyms_updated.text.toString())

                Toast.makeText(this,"Word Updated!",
                    Toast.LENGTH_LONG).show()

                GlobalScope.launch {
                    database.dao().updateWord(Entity(pos+1,word_updated.text.toString(),meaning_updated.text.toString(),
                        sentence_updated.text.toString(),place_of_encounter_updated.text.toString(),synonyms_updated.text.toString()))
                }
                myIntent()
            }
        }
    }

    fun myIntent(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}