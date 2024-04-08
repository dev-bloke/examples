package uk.martiningram.example.restaurant.domain

import uk.martiningram.example.restaurant.data.RestaurantsRepository

class GetSortedRestaurantsUseCase {

    private val repository: RestaurantsRepository = RestaurantsRepository()

    suspend operator fun invoke(): List<Restaurant> {
        return repository.getRestaurants().sortedBy { it.title }
    }
}