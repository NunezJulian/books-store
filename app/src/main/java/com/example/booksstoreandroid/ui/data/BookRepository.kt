package com.example.booksstoreandroid.ui.data

import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.data.model.BookProvider
import com.example.booksstoreandroid.ui.data.network.BookService

class BookRepository {
  private val api = BookService()

  suspend fun getAllBooks(): List<BookModel> {
    val response = api.getAllBooks()
    BookProvider.books = response
    return response
  }

  suspend fun getBestSellers(): List<String> {
    val response = api.getBestSellers()
    BookProvider.bestSellers = response
    return response
  }
}