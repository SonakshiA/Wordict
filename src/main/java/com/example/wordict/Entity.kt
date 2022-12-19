package com.example.wordict

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Words")
data class Entity (

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    var word:String,
    var meaning:String,
    var sentence:String,
    var placeOfEncounter:String,
    var synonyms: String
    )