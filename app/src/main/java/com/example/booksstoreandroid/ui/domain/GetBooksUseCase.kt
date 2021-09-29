package com.example.booksstoreandroid.ui.domain

import com.example.booksstoreandroid.ui.data.BookRepository

class GetBooksUseCase {
  private val repository = BookRepository()

  suspend operator fun invoke() = repository.getAllBooks()
}