package com.almogdadjabir.hifi.view.main


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
import androidx.compose.ui.draw.scale
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
import com.almogdadjabir.hifi.model.products.Data
import com.almogdadjabir.hifi.ui.theme.dark
import com.almogdadjabir.hifi.ui.theme.darkLight
import com.almogdadjabir.hifi.ui.theme.poppins_black
import com.almogdadjabir.hifi.ui.theme.poppins_regular
import com.almogdadjabir.hifi.view_model.ProductViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalCoilApi
@Composable
fun Main(
    navHostController: NavHostController,
    productViewModel: ProductViewModel = hiltViewModel(),

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
                        ScrollerBar()

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

                        SneakersDeals()


                        val list by productViewModel.allProducts.observeAsState()
                        list?.let { DrawUI(it, navHostController) } ?: Text(
                            text = "Wait",
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )


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


@OptIn(ExperimentalCoilApi::class)
@Composable
fun ScrollerBar(){
    val painter = rememberImagePainter(data = "", builder = {
        transformations(RoundedCornersTransformation(10f))
        error(R.drawable.bg)
    })
    val painter2 = rememberImagePainter(data = "", builder = {
        transformations(RoundedCornersTransformation(10f))
        error(R.drawable.ic_shose)
    })



    Card(
        backgroundColor = Color(0xffffffff),
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(32.dp)),
    ) {
        Image(painter = painter, contentDescription = "Just Image")

        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Row() {
                Text(
                    modifier = Modifier
                        .weight(2f)
                        .padding(16.dp),
                    text = "New items with \n free shipping ",
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontFamily = poppins_black,
                    maxLines = 3,
                    fontSize = 28.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.ExtraBold
                )

//            Image(
//                painter = painter2,
//                contentDescription = "Just Image",
//                Modifier.weight(1f)
//                )


            }


            Button(
                onClick = {},
                modifier = Modifier
                    .defaultMinSize(minHeight = 45.dp, minWidth = 150.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),

                colors= ButtonDefaults.buttonColors(backgroundColor = Color(0xffeeeeee)),
            ) {
                Text(text = "Check")
            }
        }
       


    } // end of card


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
                   modifier = Modifier
                       .padding(16.dp)
                       .weight(1f))
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
                   modifier = Modifier
                       .padding(16.dp)
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

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalCoilApi
@Composable
fun DrawUI(list: List<Data>, navHostController: NavHostController) {
    // set background color
    Log.d("lol", "DrawUI: List Size =  ${list.size}")

//    var i by remember {
//        mutableStateOf(0)
//    }
    var i by remember {
        mutableStateOf(0)
    }



    LazyRow(
        // fix the item in one row to be 2.
        //cells = GridCells.Fixed(2),

        contentPadding = PaddingValues(8.dp),
    ) {


        items(list) { item ->
           // Log.d("item.images","${item.images?.get(i)?.url}")



            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp) ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                    ,

                    ) {

                    val painter = rememberImagePainter(data = "${item.images?.get(0)?.url}", builder = {
                        transformations(RoundedCornersTransformation(10f))
                        error(R.drawable.ic__animal_ears_hat_layer_photo_icon)
                    })
                    Image(painter = painter,  contentDescription = "Just Image",modifier = Modifier.defaultMinSize(minWidth = 100.dp,minHeight = 100.dp))
                    val state = painter.state
                    if ((state is ImagePainter.State.Loading) || (state is ImagePainter.State.Error)) {
                         CircularProgressIndicator()
                    }


                } // end of card

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${item.price}",
                    modifier = Modifier.padding(start = 20.dp),
                    fontFamily = poppins_regular,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${item.name}",
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
