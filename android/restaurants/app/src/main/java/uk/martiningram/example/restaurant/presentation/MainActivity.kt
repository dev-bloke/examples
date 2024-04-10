package uk.martiningram.example.restaurant.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import dagger.hilt.android.AndroidEntryPoint
import uk.martiningram.example.restaurant.presentation.details.RestaurantDetailsScreen
import uk.martiningram.example.restaurant.presentation.details.RestaurantDetailsViewModel
import uk.martiningram.example.restaurant.presentation.list.RestaurantsScreen
import uk.martiningram.example.restaurant.presentation.list.RestaurantsViewModel
import uk.martiningram.example.restaurant.ui.theme.RestaurantsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantsTheme {
                RestaurantsApp()
            }
        }
    }
}

@Composable
private fun RestaurantsApp() {
    /*
     * TIP: This is how to do navigation with routes and a controller. Note the view model injection.
     */
    val navController = rememberNavController()
    NavHost(navController, startDestination = "restaurants") {
        composable(route = "restaurants") {
            val viewModel: RestaurantsViewModel = hiltViewModel()
            RestaurantsScreen(
                state = viewModel.state.value,
                onItemClick = { id -> navController.navigate("restaurants/$id") },
                onFavouriteClick = { id, oldValue -> viewModel.toggleFavourite(id, oldValue) }
            )
        }
        composable(
            route = "restaurants/{restaurant_id}",
            deepLinks = listOf(navDeepLink { uriPattern ="www.restaurantsapp.details.com/{restaurant_id}" }),
            arguments = listOf(navArgument("restaurant_id") { type = NavType.IntType })
        ) {
            val viewModel: RestaurantDetailsViewModel = hiltViewModel()
            RestaurantDetailsScreen(
                item = viewModel.state.value
            )
        }
    }
}