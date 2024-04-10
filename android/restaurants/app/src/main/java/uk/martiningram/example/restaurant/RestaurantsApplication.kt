package uk.martiningram.example.restaurant

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/*
 * TIP Hilt establishes application context with this annotation.
 */
@HiltAndroidApp
class RestaurantsApplication: Application()