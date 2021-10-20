package com.almogdadjabir.hifi

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.almogdadjabir.hifi.view.home.Home
import com.almogdadjabir.hifi.view.singin.SingIn
import com.almogdadjabir.hifi.view.singup.SingUp
import com.almogdadjabir.hifi.view.welcome.Welcome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    @OptIn(ExperimentalAnimationApi::class)
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            NavHost(
                navController = navHostController,
                startDestination = "Welcome",
                //modifier = Modifier.background(Color(0xfff9f2ec))
            ) {
                composable(
                    "Home",
                ) {
                    Home()
                }

                composable(
                    "Welcome",
                ) {
                    Welcome(navHostController)
                }

                composable(
                    "Singin",
                ) {
                    SingIn(navHostController)
                }

                composable(
                    "Singup",
                ) {
                    SingUp(navHostController)
                }


            }
        }
    }
}