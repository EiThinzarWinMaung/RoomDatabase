package com.example.wordroomdb.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.wordroomdb.model.Book

@Dao
interface BookDao {

    @Query(value = "Select * from book_name ORDER BY book_name ASC")
//  @Query(value = "Select * from BookTable")
    fun getAllBook(): LiveData<List<Book>>    // getter (SELECT)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)        // setter (INSERT)

    @Query("Delete from book_name")
    suspend fun deleteAll()             // deleter (DELETE)
}