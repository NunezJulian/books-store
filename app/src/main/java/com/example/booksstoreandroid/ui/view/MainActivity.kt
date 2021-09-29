package com.example.booksstoreandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.booksstoreandroid.R
import com.example.booksstoreandroid.databinding.ActivityMainBinding
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.data.model.BookProvider
import com.example.booksstoreandroid.ui.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val bookViewModel: BookViewModel by viewModels()

    private lateinit var bestSellerBooks: List<BookModel>

    private lateinit var booksGroupedBy: List<BookModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookViewModel.onCreate()

        bookViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        bookViewModel.bestSellers.observe(this, Observer {

//            Log.e("","")
        })

        bookViewModel.books.observe(this, Observer {
//            Log.e("","")
        })


//        bestSellerBooks = BookProvider.books.filter { (key,value) -> key == "isbn" && BookProvider.bestSellers.contains(value) }
    }
}