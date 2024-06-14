package uk.martiningram.example.restaurant.data.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.martiningram.example.restaurant.data.local.RestaurantsDao
import uk.martiningram.example.restaurant.data.local.RestaurantsDb
import uk.martiningram.example.restaurant.data.remote.RestaurantsAPIService
import javax.inject.Singleton

/*
 * TIP: Singleton module for dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
object RestaurantsModule {

    private val tag = "RestaurantsModule"

    @Provides
    fun provideRoomDao(database: RestaurantsDb): RestaurantsDao {
        Log.d(tag, "Provide Room DAO")
        return database.dao
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext appContext: Context): RestaurantsDb {
        Log.d(tag, "Provide Room Database")
        return Room.databaseBuilder(
            appContext,
            RestaurantsDb::class.java,
            "restaurants_database")
            .fallbackToDestructiveMigration().build()
    }

    // TIP: 10.0.2.2 routes to localhost on your development machine.
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        Log.d(tag, "Provide Retrofit")
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/")
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RestaurantsAPIService {
        Log.d(tag, "Provide API Service")
        return retrofit.create(RestaurantsAPIService::class.java)
    }
}