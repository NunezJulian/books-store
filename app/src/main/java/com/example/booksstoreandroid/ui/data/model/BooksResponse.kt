package com.example.booksstoreandroid.ui.data.model


import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("results")
    val results: Results
)