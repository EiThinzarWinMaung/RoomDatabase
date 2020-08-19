package com.example.wordroomdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.wordroomdb.adapter.BookAdapter
import com.example.wordroomdb.database.BookDatabase
import com.example.wordroomdb.model.Book
import com.example.wordroomdb.viewmodel.BookViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewmodel: BookViewmodel
    private lateinit var bookAdapter: BookAdapter

    private val addBookActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            BookDatabase::class.java,
//            "BookDB"
//        ).build()

//        Thread {
//            val book = Book(2, "Android Development")
//
//            db.bookDao().saveBook(book)
//            db.bookDao().getAllBook().forEach {
//                Log.d("Fetch Database >>>>>>>", "${it.bookID}")
//                Log.d("Fetch Database >>>>>>>", "${it.bookName}")
//            }
//        }.start()

        bookViewmodel = ViewModelProviders.of(this).get(BookViewmodel::class.java)

        bookAdapter = BookAdapter()

        recyclerviewBook.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookAdapter
        }

        bookViewmodel.allBook.observe(this, Observer { book ->
            book.let {
                bookAdapter.addBookList(book)
            }
        })

        btnAdd.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent, addBookActivityRequestCode)
        }

        btnDelete.setOnClickListener {
            bookViewmodel.delete()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == addBookActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(AddBookActivity.EXTRA_REPLY)?.let {
                val book = Book(it)
                bookViewmodel.insert(book)
            }
        }
    }
}