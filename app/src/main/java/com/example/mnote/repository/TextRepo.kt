package com.example.mnote.repository

import com.example.mnote.database.TextDao
import com.example.mnote.model.User

class TextRepo (private val textDao : TextDao){


    fun addText(text : User){
        textDao.addTitle(text)
    }
}