package com.example.booksstoreandroid.ui.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksstoreandroid.ui.data.model.BookModel

class BookMainAdapter(val booksData: List<BookModel>): RecyclerView.Adapter<BookMainAdapter.BookHolder>() {
  class BookHolder(val view: View): RecyclerView.ViewHolder(view) {

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
    TODO("Not yet implemented")
  }

  override fun onBindViewHolder(holder: BookHolder, position: Int) {
    TODO("Not yet implemented")
  }

  override fun getItemCount(): Int {
    TODO("Not yet implemented")
  }
}