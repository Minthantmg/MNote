package com.example.mnote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mnote.database.TextDao
import com.example.mnote.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TextRepo (private val textDao : TextDao){

    val readAllData : LiveData<List<User>> = textDao.readAllData()


    fun addText(text : User){
        textDao.addTitle(text)
    }

    fun deleteAllUser(){
        textDao.deleteAllUser()
    }
}