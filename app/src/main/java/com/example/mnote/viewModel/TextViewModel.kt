package com.example.mnote.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mnote.database.TextDatabase
import com.example.mnote.model.User
import com.example.mnote.repository.TextRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TextViewModel(application : Application) : AndroidViewModel(application) {
    private val repository : TextRepo

    val readAllData : LiveData<List<User>>

    init {
        val TextDao =TextDatabase.getDatabase(application).textDao()
        repository = TextRepo(TextDao)
        readAllData = repository.readAllData
    }

    fun addTitle(text : User){
        viewModelScope.launch (Dispatchers.IO){
            repository.addText(text)
        }
    }

    fun deleteAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }
}