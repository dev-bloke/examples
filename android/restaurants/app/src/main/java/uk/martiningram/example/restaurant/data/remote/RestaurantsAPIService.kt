package uk.martiningram.example.restaurant.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantsAPIService {
    @GET("restaurants/")
    suspend fun getRestaurants(): List<RemoteRestaurant>

    @GET("restaurants/{id}")
    suspend fun getRestaurant(@Path("id") id: Int, @Query("random") rand: Int): RemoteRestaurant
}