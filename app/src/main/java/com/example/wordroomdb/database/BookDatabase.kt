package com.example.wordroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wordroomdb.dao.BookDao
import com.example.wordroomdb.model.Book

@Database(entities = arrayOf(Book::class), version = 1)
abstract class BookDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {

        private var INSTANCE: BookDatabase? = null

        fun getDatabase(context: Context): BookDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java,
                    "book_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}