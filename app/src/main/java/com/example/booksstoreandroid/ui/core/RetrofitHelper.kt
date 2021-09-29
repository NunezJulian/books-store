package com.example.booksstoreandroid.ui.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
  fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://raw.githubusercontent.com/ejgteja/files/main/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}