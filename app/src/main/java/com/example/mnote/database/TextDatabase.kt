package com.example.mnote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mnote.model.User

@Database(entities = [User::class],version = 1)
abstract class TextDatabase : RoomDatabase(){

    abstract fun textDao() : TextDao

    companion object{
        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(context : Context) : TextDatabase {
            val tampInstance = INSTANCE
            if (tampInstance != null) {
                return tampInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }
    }
}