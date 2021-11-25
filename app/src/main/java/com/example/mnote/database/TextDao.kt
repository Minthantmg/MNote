package com.example.mnote.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mnote.model.User

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTitle(title : User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>

    @Query("DELETE FROM user_table")
    fun deleteAllUser()
}