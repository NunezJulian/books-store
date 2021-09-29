package com.example.booksstoreandroid.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.data.model.SectionModel
import com.example.booksstoreandroid.ui.domain.GetBestSellersUseCase
import com.example.booksstoreandroid.ui.domain.GetBooksUseCase
import com.example.booksstoreandroid.ui.domain.GetSectionsUseCase
import kotlinx.coroutines.launch

class BookViewModel: ViewModel() {
  val isLoading = MutableLiveData<Boolean>()
  val books = MutableLiveData<List<BookModel>>()
  val hasFinished = MutableLiveData<Boolean>()
  val sections = MutableLiveData<List<SectionModel>>()
  val bestSellers = MutableLiveData<List<String>>()

  var getBooksUseCase = GetBooksUseCase()
  var getBestSellersUseCase = GetBestSellersUseCase()
  var getSectionsUseCase = GetSectionsUseCase()
  fun onCreate() {
    viewModelScope.launch {
      hasFinished.postValue(false)
      isLoading.postValue(true)
      val booksResult = getBooksUseCase()
      val bestSellersResult = getBestSellersUseCase()
      if(!booksResult.isNullOrEmpty()) {
        books.postValue(booksResult)
        bestSellers.postValue(bestSellersResult)
        isLoading.postValue(false)
        hasFinished.postValue(true)
      }
    }
  }

  fun getSections() {
    val sectionsResult = getSectionsUseCase()
    sections.postValue(sectionsResult)
  }
}