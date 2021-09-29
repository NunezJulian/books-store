package com.example.booksstoreandroid.ui.data.network

import com.example.booksstoreandroid.ui.data.model.BestSellersResponse
import com.example.booksstoreandroid.ui.data.model.BooksResponse
import retrofit2.Response
import retrofit2.http.GET

interface BookApi {
  @GET("books.json")
  suspend fun getAllBooks(): Response<BooksResponse>

  @GET("best_sellers.json")
  suspend fun getBestSellers(): Response<BestSellersResponse>
}