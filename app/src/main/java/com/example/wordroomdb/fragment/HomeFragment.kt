package com.example.wordroomdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.wordroomdb.R
import com.example.wordroomdb.model.Book
import com.example.wordroomdb.viewmodel.BookViewmodel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        var bookViewmodel = ViewModelProvider(this).get(BookViewmodel::class.java)
//        bookViewmodel.insert(Book("Android Development"))
//        txtName.text = bookViewmodel.allBook.get(0).bookName
    }
}