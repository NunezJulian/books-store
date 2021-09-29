package com.example.booksstoreandroid.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksstoreandroid.R
import com.example.booksstoreandroid.databinding.ActivityMainBinding
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.data.model.BookProvider
import com.example.booksstoreandroid.ui.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bookViewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookViewModel.onCreate()

        bookViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        bookViewModel.hasFinished.observe(this, Observer {
            if(it) {
                bookViewModel.getSections()
            }
        })

        bookViewModel.sections.observe(this, Observer {
                binding.rvMainBooks.setHasFixedSize(true)
                binding.rvMainBooks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMainBooks.adapter = SectionAdapter(this, it)
        })

    }
}