package com.example.wordict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val database: myDatabase by lazy{
            myDatabase.getDatabase(this)
        }

        save_button.setOnClickListener {
            if(word.text.toString().isNotEmpty() && meaning.text.toString().isNotEmpty()  && sentence.text.toString().isNotEmpty()
                && place_of_encounter.text.toString().isNotEmpty() && synonyms.text.toString().isNotEmpty()){
                var word = word.text.toString()
                var meaning = meaning.text.toString()
                var sentence = sentence.text.toString()
                var placeOfEncounter = place_of_encounter.text.toString()
                var synonyms = synonyms.text.toString()

                DataObject.setData(word,meaning, sentence, placeOfEncounter, synonyms)
                GlobalScope.launch {
                    database.dao().insertWord(Entity(0,word,meaning,sentence, placeOfEncounter, synonyms))
                }
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}