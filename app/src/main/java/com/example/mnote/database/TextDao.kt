package com.example.mnote.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mnote.model.User

@Dao
interface TextDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTitle(title : User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData() : LiveData<List<User>>

    @Query("DELETE FROM user_table")
    fun deleteAllUser()

    @Update
    fun updateUser(user : User)

    @Delete
    fun deleteText(user : User)
}