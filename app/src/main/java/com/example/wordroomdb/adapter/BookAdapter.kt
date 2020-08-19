package com.example.wordroomdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wordroomdb.R
import com.example.wordroomdb.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var books = emptyList<Book>()

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book) {
            itemView.txtBookName.text = book.bookName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        return holder.bind(books[position])
    }

    fun addBookList(book: List<Book>) {
        this.books = book
        notifyDataSetChanged()
    }

}