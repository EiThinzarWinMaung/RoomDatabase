package com.example.wordroomdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
 @Entity(tableName = "book_name")
class Book
(
    @PrimaryKey
//    @ColumnInfo(name = "id")
//    var bookID: Int = 0,

    @ColumnInfo(name = "book_name")
    var bookName: String = ""


//    @PrimaryKey
//    @ColumnInfo(name = "id")
//    var bookID: Int,
//
//    @ColumnInfo(name = "book_name")
//    var bookName: String
)