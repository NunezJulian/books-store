package com.example.booksstoreandroid.ui.data.model


import com.google.gson.annotations.SerializedName

data class ResultsBestSellers(
    @SerializedName("best_sellers")
    val bestSellers: List<String>
)