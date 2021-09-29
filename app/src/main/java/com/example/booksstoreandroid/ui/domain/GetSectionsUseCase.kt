package com.example.booksstoreandroid.ui.domain

import android.util.Log
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.data.model.BookProvider
import com.example.booksstoreandroid.ui.data.model.SectionModel

class GetSectionsUseCase {
  private lateinit var bestSellerBooks: List<BookModel>
  private lateinit var sections: ArrayList<SectionModel>

  operator fun invoke():List<SectionModel> {
    val allBooks = BookProvider.books
    val bestSellers = BookProvider.bestSellers
    sections = ArrayList()
    if(!allBooks.isNullOrEmpty()) {
      bestSellerBooks = allBooks.filter {
           it.isbn in bestSellers
      }

      var sectionsGroupedByGenre = allBooks.groupBy { it.genre }.map { (key, value) -> SectionModel(key, value) }

      val bestSellersSection = SectionModel(
        "Best Sellers", bestSellerBooks
      )
      sections.add(bestSellersSection)
      sections.addAll(sectionsGroupedByGenre)
      return sections
    }
    return emptyList()
  }
}