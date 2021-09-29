package com.example.booksstoreandroid.ui.data.model


import com.google.gson.annotations.SerializedName

data class BookModel(
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("imported")
    val imported: Boolean,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("title")
    val title: String
)