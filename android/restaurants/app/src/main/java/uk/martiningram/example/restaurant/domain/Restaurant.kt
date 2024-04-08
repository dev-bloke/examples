package uk.martiningram.example.restaurant.domain

data class Restaurant(
    val id: Int,
    val title: String,
    val description: String,
    val isFavourite: Boolean = false
)