package com.example.wordroomdb.repository

import androidx.lifecycle.LiveData
import com.example.wordroomdb.dao.BookDao
import com.example.wordroomdb.model.Book

class BookRepository (private val bookDao: BookDao) {

    val allBook: LiveData<List<Book>> = bookDao.getAllBook()

    suspend fun bookInsert(book: Book) {
        bookDao.insert(book)
    }

    suspend fun bookDelete() {
        bookDao.deleteAll()
    }
}