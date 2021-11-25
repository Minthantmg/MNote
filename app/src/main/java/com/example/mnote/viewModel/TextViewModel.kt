package com.example.mnote.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mnote.database.TextDatabase
import com.example.mnote.model.User
import com.example.mnote.repository.TextRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TextViewModel(application : Application) : AndroidViewModel(application) {
    private val repository : TextRepo

    init {
        val TextDao =TextDatabase.getDatabase(application).textDao()
        repository = TextRepo(TextDao)
    }

    fun addTitle(text : User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addText(text)
        }
    }
}