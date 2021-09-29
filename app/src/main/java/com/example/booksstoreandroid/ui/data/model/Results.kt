package com.example.booksstoreandroid.ui.data.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("books")
    val bookModels: List<BookModel>
)