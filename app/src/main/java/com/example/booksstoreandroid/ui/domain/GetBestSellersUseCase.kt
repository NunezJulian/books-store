package com.example.booksstoreandroid.ui.domain

import com.example.booksstoreandroid.ui.data.BookRepository

class GetBestSellersUseCase {
  private val repository = BookRepository()

  suspend operator fun invoke() = repository.getBestSellers()
}