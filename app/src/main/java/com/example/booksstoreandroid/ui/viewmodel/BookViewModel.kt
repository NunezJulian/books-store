package com.example.booksstoreandroid.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksstoreandroid.ui.data.model.BookModel
import com.example.booksstoreandroid.ui.domain.GetBestSellersUseCase
import com.example.booksstoreandroid.ui.domain.GetBooksUseCase
import kotlinx.coroutines.launch

class BookViewModel: ViewModel() {
  val isLoading = MutableLiveData<Boolean>()
  val books = MutableLiveData<List<BookModel>>()
  val bestSellers = MutableLiveData<List<String>>()
  var getBooksUseCase = GetBooksUseCase()
  var getBestSellersUseCase = GetBestSellersUseCase()
  fun onCreate() {
    viewModelScope.launch {
      isLoading.postValue(true)
      val booksResult = getBooksUseCase()
      val bestSellersResult = getBestSellersUseCase()
      if(!booksResult.isNullOrEmpty()) {
        books.postValue(booksResult)
        bestSellers.postValue(bestSellersResult)
        Log.e("", "")
        isLoading.postValue(false)
      }
    }
  }
}