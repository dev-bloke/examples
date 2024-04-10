package uk.martiningram.example.restaurant.presentation.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.martiningram.example.restaurant.data.remote.RestaurantsAPIService
import uk.martiningram.example.restaurant.domain.Restaurant
import javax.inject.Inject

@HiltViewModel
class RestaurantDetailsViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private var restInterface: RestaurantsAPIService
    ) : ViewModel() {

    val state = mutableStateOf<Restaurant?>(null)

    init {
        val id = stateHandle.get<Int>("restaurant_id")?: 0
        viewModelScope.launch {
            val restaurant = getRemoteRestaurant(id)
            state.value = restaurant
        }
    }

    private suspend fun getRemoteRestaurant(id: Int): Restaurant {
        // JSON Server sends HTTP 304 unless you add a random query parameter.
        val rand = (0..9999999).random()
        return withContext(Dispatchers.IO) {
            val restaurant = restInterface.getRestaurant(id, rand)
            return@withContext Restaurant(
                id = restaurant.id,
                title = restaurant.title,
                description = restaurant.description)
        }
    }
}