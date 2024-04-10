package uk.martiningram.example.restaurant.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import uk.martiningram.example.restaurant.data.remote.RestaurantsAPIService
import uk.martiningram.example.restaurant.data.local.LocalRestaurant
import uk.martiningram.example.restaurant.data.local.PartialLocalRestaurant
import uk.martiningram.example.restaurant.data.local.RestaurantsDao
import uk.martiningram.example.restaurant.domain.Restaurant
import java.net.ConnectException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.inject.Singleton

/*
 * TIP: A repository manages online and offline caching.
 */
@Singleton
class RestaurantsRepository @Inject constructor(
    private var restInterface: RestaurantsAPIService,
    private var restaurantsDao: RestaurantsDao
    ) {

    suspend fun loadRestaurants() {
        return withContext(Dispatchers.IO) {
            try {
                refreshCache()
            } catch (e: Exception) {
                when (e) {
                    is UnknownHostException,
                    is ConnectException,
                    is HttpException -> {
                        if (restaurantsDao.getAll().isEmpty()) {
                            throw Exception("Something went wrong, we have no data.")
                        }
                    }
                    else -> throw(e)
                }
            }
        }
    }

    suspend fun getRestaurants(): List<Restaurant> {
        return withContext(Dispatchers.IO) {
            return@withContext restaurantsDao.getAll().map {
                Restaurant(it.id, it.title, it.description, it.isFavourite)
            }
        }
    }

    suspend fun updateFavouriteRestaurant(id: Int, value: Boolean) =
        withContext(Dispatchers.IO) {
            restaurantsDao.update(PartialLocalRestaurant(id = id, isFavourite = value))
        }

    private suspend fun refreshCache() {
        val remoteRestaurants = restInterface.getRestaurants()
        val favouriteRestaurants = restaurantsDao.getAllFavourited()
        restaurantsDao.addAll(remoteRestaurants.map {
            LocalRestaurant(it.id, it.title, it.description, false)
        })
        restaurantsDao.updateAll(favouriteRestaurants.map { PartialLocalRestaurant(it.id, true) })
    }
}