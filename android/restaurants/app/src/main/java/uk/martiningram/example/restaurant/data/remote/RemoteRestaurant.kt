package uk.martiningram.example.restaurant.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteRestaurant (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String
)