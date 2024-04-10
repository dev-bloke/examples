package uk.martiningram.example.restaurant.domain

import uk.martiningram.example.restaurant.data.RestaurantsRepository
import javax.inject.Inject

class ToggleFavouriteRestaurantUseCase @Inject constructor(
    private val repository: RestaurantsRepository,
    private val getSortedRestaurantsUseCase: GetSortedRestaurantsUseCase
    ){

    suspend operator fun invoke(id: Int, favourite: Boolean): List<Restaurant> {
        val newFavourite = favourite.not()
        repository.updateFavouriteRestaurant(id, newFavourite)
        return getSortedRestaurantsUseCase()
    }
}