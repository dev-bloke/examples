package uk.martiningram.example.restaurant.presentation.list

import uk.martiningram.example.restaurant.domain.Restaurant

/*
 * TIP: Use a screen / view state object, managed by the view model.
 */
data class RestaurantsScreenState(
    val restaurants: List<Restaurant>,
    val isLoading: Boolean,
    val error: String? = null
)