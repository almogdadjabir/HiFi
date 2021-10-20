package com.almogdadjabir.hifi.view.welcome

import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.almogdadjabir.hifi.R
import com.almogdadjabir.hifi.ui.theme.dark
import com.example.fortest.EmojiViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.*


@Composable
fun Welcome(
    navHostController: NavHostController,
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        visible = true
    }

    WelcomeScreenContent(visible = visible, navHostController) {
    }
}

@Composable
fun WelcomeScreenContent(
    visible: Boolean,
    navHostController: NavHostController,
    onGetStarted: () -> Unit
) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(dark)
        ) {
            AnimatedTitle(visible = visible)

            AnimatedImage(visible = visible)

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedButton(visible = visible,
                onClick = { navHostController.navigate("Home") }
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedTitle(visible: Boolean, viewModel: EmojiViewModel = viewModel()) {
    val titleEnterTransition = fadeIn(
        animationSpec = tween(1000, 1600)
    ) + slideInVertically(
        initialOffsetY = { -100 },
        animationSpec = tween(1000, 1600)
    )

    AnimatedVisibility(
        visible = visible,
        enter = titleEnterTransition,
    ) {
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hi-Fi E-Commerce",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )

            val data by viewModel.data.observeAsState()
            data?.let { Text(text = it,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedImage(visible: Boolean) {
    val imageEnterTransition = fadeIn(
        animationSpec = tween(2000)
    )

    AnimatedVisibility(
        visible = visible,
        enter = imageEnterTransition,
    ) {

        Loader()

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedButton(visible: Boolean, onClick: () -> Unit) {
    val buttonEnterTransition = fadeIn(
        animationSpec = tween(1000, 2600)
    ) + slideInVertically(
        initialOffsetY = { 100 },
        animationSpec = tween(1000, 2600)
    )

    AnimatedVisibility(
        visible = visible,
        enter = buttonEnterTransition,
    ) {

        Button(
            onClick = onClick,
            modifier = Modifier
                .defaultMinSize(minHeight = 75.dp, minWidth = 200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),

            colors= ButtonDefaults.buttonColors(backgroundColor = Color(0xffeeeeee)),
        ) {
            Text(text = "Get Started")
        }
    }
}


@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    LottieAnimation(
        composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.fillMaxHeight(0.6f).fillMaxWidth()
    )


}

