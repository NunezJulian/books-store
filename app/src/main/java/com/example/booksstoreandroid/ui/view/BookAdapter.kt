package com.example.booksstoreandroid.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksstoreandroid.databinding.BookItemBinding
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.squareup.picasso.Picasso

class BookAdapter(context: Context, booksData: List<BookModel>): RecyclerView.Adapter<BookAdapter.BookHolder>() {

  private val items: List<BookModel>
  private val context: Context

  init {
    this.items = booksData
    this.context = context
  }

  inner class BookHolder(val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
    val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return BookHolder(binding)
  }

  override fun onBindViewHolder(holder: BookHolder, position: Int) {
    with(holder) {
      with(items[position]) {
        binding.txtBookTitle.text = this.title
        binding.txtBookAuthor.text = this.author
        Picasso.get().load(this.img).into(binding.imgItemBook)
      }
    }

  }

  override fun getItemCount(): Int {
    return items.count()
  }
}