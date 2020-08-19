package com.example.wordroomdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordroomdb.database.BookDatabase
import com.example.wordroomdb.model.Book
import com.example.wordroomdb.repository.BookRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BookViewmodel(application: Application): AndroidViewModel(application) {

    private val repository: BookRepository
    val allBook: LiveData<List<Book>>

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        repository = BookRepository(bookDao)
        allBook = repository.allBook
    }

    fun insert(book: Book) = viewModelScope.launch {
        repository.bookInsert(book)
    }

    fun delete() = viewModelScope.launch {
        repository.bookDelete()
    }
}