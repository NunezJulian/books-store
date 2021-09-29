package com.example.booksstoreandroid.ui.data.model

class BookProvider {
  companion object {
    var books: List<BookModel> = emptyList()
    var bestSellers: List<String> = emptyList()
  }
}