package uk.martiningram.example.restaurant.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import uk.martiningram.example.restaurant.domain.GetInitialRestaurantsUseCase
import uk.martiningram.example.restaurant.domain.ToggleFavouriteRestaurantUseCase

class RestaurantsViewModel(): ViewModel() {

    /*
     * TIP: Use cases separate data logic from business logic (sorting etc.).
     */
    private val getInitialRestaurantsUseCase = GetInitialRestaurantsUseCase()
    private val toggleFavouriteRestaurantUseCase = ToggleFavouriteRestaurantUseCase()

    /*
     * TIP: Screen state object with a backing property, updated with _state.value.copy.
     */
    private val _state = mutableStateOf(RestaurantsScreenState(restaurants = listOf(), isLoading = true))
    val state: State<RestaurantsScreenState> get() = _state

    /*
     * TIP: Use a centralised error handler.
     */
    private val errorHandler = CoroutineExceptionHandler {_, exception ->
        exception.printStackTrace()
        _state.value = _state.value.copy(error = exception.message, isLoading = false)
    }

    init { getRestaurants() }


    fun toggleFavourite(id: Int, favourite: Boolean) {
        viewModelScope.launch {
            val updatedRestaurants = toggleFavouriteRestaurantUseCase(id, favourite)
            _state.value = _state.value.copy(restaurants = updatedRestaurants)
        }
    }
    
    private fun getRestaurants() {
        viewModelScope.launch(errorHandler) {
            val restaurants = getInitialRestaurantsUseCase()
            _state.value = _state.value.copy(restaurants = restaurants, isLoading = false)
        }
    }
}