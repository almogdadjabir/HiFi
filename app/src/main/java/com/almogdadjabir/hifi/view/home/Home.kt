package com.almogdadjabir.hifi.view.home

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.almogdadjabir.hifi.other.Constants
import com.almogdadjabir.hifi.ui.theme.dark
import com.almogdadjabir.hifi.view.cart.Cart
import com.almogdadjabir.hifi.view.main.Main
import com.almogdadjabir.hifi.view.profile.Profile
import com.almogdadjabir.hifi.view.search.Search

import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnrememberedGetBackStackEntry")
@ExperimentalCoilApi
@Composable
fun Home(

) {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = dark
    )
    Surface(color = dark) {

        // Scaffold Component
        Scaffold(
            // Bottom navigation

            bottomBar = {
                BottomAppBar(
                    backgroundColor = dark
                )
                {
                    BottomNavigationBar(
                    navController = navController,
               )
                }


            },
            content = {
                NavHost(navController = navController, startDestination = "Main"){

                    composable(
                        "Main",
                    ) {
                        Main(navController)
                    }


                    composable(
                        "Search",
                    ) {
                        Search(navController)
                    }
                    composable(
                        "Cart",

                    ) {
                        Cart(navController)
                    }
                    composable(
                        "Profile",

                    ) {
                        Profile(navController)
                    }


                }

            }
        )
    }


}


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(

        // set background color
        backgroundColor = dark) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label , tint = Color.White)
                },

                // label
                label = {
                    Text(text = navItem.label, color = Color.White)
                },
                alwaysShowLabel = false,


            )
        }

    }
}