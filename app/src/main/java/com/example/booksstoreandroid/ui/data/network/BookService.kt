package com.example.booksstoreandroid.ui.data.network

import com.example.booksstoreandroid.ui.core.RetrofitHelper
import com.example.booksstoreandroid.ui.data.model.BookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookService {
  private val retrofit = RetrofitHelper.getRetrofit()

  suspend fun getAllBooks(): List<BookModel> {
    return withContext(Dispatchers.IO) {
      val response = retrofit.create(BookApi::class.java).getAllBooks()
      response.body()?.results?.bookModels ?: emptyList()
    }
  }

  suspend fun getBestSellers(): List<String> {
    return withContext(Dispatchers.IO) {
      val response = retrofit.create(BookApi::class.java).getBestSellers()
      response.body()?.results?.bestSellers ?: emptyList()
    }
  }
}