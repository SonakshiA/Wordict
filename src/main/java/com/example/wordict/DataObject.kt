package com.example.wordict

object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(word:String, meaning:String, sentence:String, placeOfEncounter: String, synonyms:String){
        listdata.add(CardInfo(word,meaning, sentence, placeOfEncounter, synonyms))
    }

    fun getAllData():List<CardInfo>{
        return listdata
    }

    fun getWord(pos:Int):CardInfo{
        return listdata[pos]
    }

    fun deleteWord(pos: Int){
        listdata.removeAt(pos)
    }

    fun updateItem(pos:Int,word:String, meaning:String, sentence:String, placeOfEncounter: String, synonyms:String){
        listdata[pos].word = word
        listdata[pos].meaning = meaning
        listdata[pos].sentence = sentence
        listdata[pos].placeOfEncounter = placeOfEncounter
        listdata[pos].synonyms = synonyms
    }

    fun size():Int{
        return listdata.size
    }
}