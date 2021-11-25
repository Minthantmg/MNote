package com.example.mnote.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.mnote.model.User

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTitle(title : User)
}