package com.example.wordict

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Insert
    suspend fun insertWord(entity: Entity)

    @Update
    suspend fun updateWord(entity: Entity)

    @Delete
    suspend fun deleteWord(entity: Entity)

    @Query("Select word, meaning, sentence, placeOfEncounter, synonyms from Words")
    suspend fun getWords():List<CardInfo>
}