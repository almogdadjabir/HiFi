package com.almogdadjabir.hifi.view.search


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.almogdadjabir.hifi.R
import com.almogdadjabir.hifi.ui.theme.dark
import com.almogdadjabir.hifi.ui.theme.darkLight
import com.almogdadjabir.hifi.ui.theme.poppins_black
import com.almogdadjabir.hifi.ui.theme.poppins_regular
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalCoilApi
@Composable
fun Search(
    navHostController: NavHostController,

    ) {

    Scaffold(
        Modifier.background( color = dark ),
        topBar = {},
        drawerContent = {/**/ },
        bottomBar = {/**/ },
        floatingActionButton = {
            //MyFloatingActionButton()

        },
        snackbarHost = {/**/ },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(dark)
                    .padding(bottom = 100.dp)

            ) {
                item() {
                    Column(
                        Modifier
                            .fillMaxSize()
                    )
                    {
                        SearchBar()

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Popular categories ",
                                color = Color.White,
                                textAlign = TextAlign.Start,
                                fontFamily = poppins_black,
                                fontSize = 14.sp,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.ExtraBold
                            )
                            TextButton(onClick = {}) {

                                Text(
                                    text = "See all ",
                                    color = Color(0xFFB7C5DF),
                                    textAlign = TextAlign.Start,
                                    fontFamily = poppins_black,
                                    fontSize = 14.sp,
                                    overflow = TextOverflow.Ellipsis,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }


                        }

                        CategoryRow()


                    }
                }
            }

        },
    )

}
@Composable
fun SearchBar(){
    var username by remember {
        mutableStateOf("")

    }
    Box(
        Modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(32.dp))
            .background(color = darkLight)

        ) {
        TextField(
            value = username,
            modifier = Modifier.fillMaxWidth() ,
            textStyle = TextStyle(color = Color.White),
            onValueChange = { username = it },
            singleLine = true,
            label = {Text(text = "I want to buy..")},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = darkLight,
                cursorColor = Color.White,
                disabledLabelColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color(0xFFf2f2f2),
                unfocusedLabelColor = Color(0xFFf2f2f2),
            ),
            trailingIcon = {
                if (username.isNotBlank())
                    IconButton(onClick = {username = ""}) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "",
                            tint = Color.White
                            )

                    }
            }
        )
    }
}



@Composable
fun CategoryRow(){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(16.dp)
                        .clip(shape = CircleShape)
                    ,
                    backgroundColor = darkLight,

                    ) {

                    Icon(
                        modifier = Modifier.padding(16.dp),

                        painter =
                    painterResource(
                        id = R.drawable.ic__076728_clothes_t_shirt_men_shopping_shirt_icon)
                        , contentDescription = "",
                        tint = Color.White,
                    )


                } // end of card

                Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "T-shirt",
                        modifier = Modifier.padding(start = 20.dp),
                        fontFamily = poppins_regular,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )

            }

        }

        //item 2
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(16.dp)
                        .clip(shape = CircleShape)
                    ,
                    backgroundColor = darkLight,

                    ) {

                    Icon(
                        modifier = Modifier.padding(16.dp),
                        painter =
                    painterResource(
                        id = R.drawable.ic__912560_clothing_dress_fashion_footwear_shoes_icon)
                        , contentDescription = "",
                        tint = Color.White,

                        )


                } // end of card

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Sneakers",
                    modifier = Modifier.padding(start = 20.dp),
                    fontFamily = poppins_regular,

                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

            }

        }

        //item 3
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(16.dp)
                        .clip(shape = CircleShape)
                    ,
                    backgroundColor = darkLight,

                    ) {

                    Icon(
                        modifier = Modifier.padding(16.dp),
                        painter =
                        painterResource(
                            id = R.drawable.ic___hoodie_jacket_icon)
                        , contentDescription = "",
                        tint = Color.White,

                        )


                } // end of card

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Hoodie",
                    fontFamily = poppins_regular,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

            }

        }

        //item 4
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .padding(16.dp)
                        .clip(shape = CircleShape)
                    ,
                    backgroundColor = darkLight,

                    ) {

                    Icon(
                        modifier = Modifier.padding(16.dp),
                        painter =
                        painterResource(
                            id = R.drawable.ic__561502_watch_icon)
                        , contentDescription = "",
                        tint = Color.White,

                        )


                } // end of card

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Watch",
                    modifier = Modifier.padding(start = 23.dp),
                    fontSize = 14.sp,
                    fontFamily = poppins_regular,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

            }

        }


    }
    // end of LazyRow
}

@Composable
fun SneakersDeals(){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sneakers for you ",
            color = Color.White,
            textAlign = TextAlign.Start,
            fontFamily = poppins_black,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(20.dp))

           Row(Modifier.fillMaxWidth()) {
               Column(
                   verticalArrangement = Arrangement.Center,
                   modifier = Modifier.padding(16.dp).
                   weight(1f))
               {
                   Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(16.dp)
                       ,

                       ) {

                       Image(
                           modifier = Modifier.padding(16.dp),

                           painter =
                           painterResource(
                               id = R.drawable.ic__1)
                           , contentDescription = "",
                       )


                   } // end of card

                   Spacer(modifier = Modifier.height(8.dp))

                   Text(
                       text = "165.50 AED",
                       modifier = Modifier.padding(start = 20.dp),
                       fontFamily = poppins_regular,
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,
                   )

                   Spacer(modifier = Modifier.height(8.dp))

                   Text(
                       text = "Nike Air Max 90",
                       modifier = Modifier.padding(start = 20.dp),
                       fontFamily = poppins_regular,
                       fontSize = 14.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,
                   )

               }

               Column(
                   verticalArrangement = Arrangement.Center,
                   modifier = Modifier.padding(16.dp)
                       .weight(1f)) {
                   Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(16.dp)
                       ,

                       ) {

                       Image(
                           modifier = Modifier.padding(16.dp),

                           painter =
                           painterResource(
                               id = R.drawable.ic__2)
                           , contentDescription = "",
                       )


                   } // end of card

                   Spacer(modifier = Modifier.height(8.dp))

                   Text(
                       text = "172.50 AED",
                       modifier = Modifier.padding(start = 20.dp),
                       fontFamily = poppins_regular,
                       fontSize = 18.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,
                   )

                   Spacer(modifier = Modifier.height(8.dp))

                   Text(
                       text = "Nike Air Max 97",
                       modifier = Modifier.padding(start = 20.dp),
                       fontFamily = poppins_regular,
                       fontSize = 14.sp,
                       fontWeight = FontWeight.Bold,
                       color = Color.White,
                   )

               }


           }



    }


}