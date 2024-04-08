package uk.martiningram.example.restaurant

import android.app.Application
import android.content.Context

/*
 * TIP This is how to establish context.
 */
class RestaurantsApplication: Application() {
    init { app = this }
    companion object {
        private lateinit var app: RestaurantsApplication
        fun getAppContext(): Context = app.applicationContext
    }
}