package com.example.mnote.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mnote.model.User
import java.util.concurrent.Flow

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

    @Query("SELECT * FROM user_table WHERE title LIKE :searchQuery OR label LIKE :searchQuery")
    fun searchDatabase(searchQuery : String) : LiveData<List<User>>
}