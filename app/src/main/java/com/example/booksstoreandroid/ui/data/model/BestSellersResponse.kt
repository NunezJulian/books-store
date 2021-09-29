package com.example.booksstoreandroid.ui.data.model


import com.google.gson.annotations.SerializedName

data class BestSellersResponse(
    @SerializedName("results")
    val results: ResultsBestSellers
)