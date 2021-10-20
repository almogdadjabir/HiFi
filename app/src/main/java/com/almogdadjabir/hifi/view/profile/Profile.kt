package com.almogdadjabir.hifi.view.profile


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.almogdadjabir.hifi.R
import com.almogdadjabir.hifi.ui.theme.*

@RequiresApi(Build.VERSION_CODES.M)
@ExperimentalCoilApi
@Composable
fun Profile(
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
                        UserInfo()

                        Divider(color = Color(0x90FFFFFF), thickness = 1.dp, modifier = Modifier.padding(start = 20.dp,end = 20.dp))

                        UserSummary()

                        UserActivity()




                    }
                }
            }

        },
    )

}



@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserInfo(){
    val painter = rememberImagePainter(data = "", builder = {
        transformations(RoundedCornersTransformation(10f))
        error(R.drawable.almogdad)
    })
    val painter2 = rememberImagePainter(data = "", builder = {
        transformations(RoundedCornersTransformation(10f))
        error(R.drawable.ic_shose)
    })



    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.White),
            painter = painter,
            contentDescription = "Just Image",
            contentScale = ContentScale.Crop,
        )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Al-Mogdad Jabir",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = poppins_regular,
                maxLines = 3,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "@almogdad",
                color = Color(0xFFf2f2f2),
                textAlign = TextAlign.Center,
                fontFamily = poppins_regular,
                maxLines = 3,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.ExtraBold
            )

        }



}

@Composable
fun UserSummary(){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {

                    Text(
                        text = "1002",
                        fontFamily = poppins_black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center

                    )

                    Text(
                        text = "Points",
                        fontFamily = poppins_regular,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center

                    )

            }

        }

        //item 2
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {

                Text(
                    text = "23",
                    fontFamily = poppins_black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center

                )

                Text(
                    text = "Purchases",
                    fontFamily = poppins_regular,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center

                )

            }

        }

        //item 3
        item() {
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)) {

                Text(
                    text = "850",
                    fontFamily = poppins_black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Deals",
                    fontFamily = poppins_regular,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center

                )

            }

        }


    }
    // end of LazyRow
}

@Composable
fun UserActivity(){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF102349), RoundedCornerShape(16.dp))
            .padding(16.dp)



    ) {

        // row 1
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(
                    backgroundColor = dark,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(6.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                    ,

                    ) {
                    Icon(Icons.Filled.Settings, "menu", modifier = Modifier.padding(10.dp), tint = Color.White)   // ok



                } // end of card

                Text(
                    text = "Settings",
                    fontFamily = poppins_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Icon(Icons.Filled.ArrowForwardIos, "menu", modifier = Modifier.height(15.dp).width(15.dp), tint = Color.White)   // ok
        }

        Spacer(modifier = Modifier.height(8.dp))

        // row 2
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(
                    backgroundColor = dark,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(6.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                    ,

                    ) {
                    Icon(Icons.Default.CreditCard, "menu", modifier = Modifier.padding(10.dp), tint = Color.White)   // ok



                } // end of card

                Text(
                    text = "Billing Details",
                    fontFamily = poppins_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Icon(Icons.Filled.ArrowForwardIos, "menu", modifier = Modifier.height(15.dp).width(15.dp), tint = Color.White)   // ok
        }
        Spacer(modifier = Modifier.height(8.dp))


        // row 3
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(
                    backgroundColor = dark,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(6.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                    ,

                    ) {
                    Icon(Icons.Default.AccountCircle, "menu", modifier = Modifier.padding(10.dp), tint = Color.White)   // ok



                } // end of card

                Text(
                    text = "Account Management",
                    fontFamily = poppins_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Icon(Icons.Filled.ArrowForwardIos, "menu", modifier = Modifier.height(15.dp).width(15.dp), tint = Color.White)   // ok
        }

        Spacer(modifier = Modifier.height(13.dp))
        Divider(color = Color(0x90FFFFFF), thickness = 1.dp)
        Spacer(modifier = Modifier.height(13.dp))


        // row 4
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(
                    backgroundColor = dark,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(6.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                    ,

                    ) {
                    Icon(Icons.Default.Info, "menu", modifier = Modifier.padding(10.dp), tint = Color.White)   // ok



                } // end of card

                Text(
                    text = "Information",
                    fontFamily = poppins_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Icon(Icons.Filled.ArrowForwardIos, "menu", modifier = Modifier.height(15.dp).width(15.dp), tint = Color.White)   // ok
        }

        Spacer(modifier = Modifier.height(8.dp))



        // row 5
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Row(horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Card(
                    backgroundColor = dark,
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(6.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                    ,

                    ) {
                    Icon(Icons.Default.SettingsPower, "menu", modifier = Modifier.padding(10.dp), tint = Color.White)   // ok



                } // end of card

                Text(
                    text = "Log out",
                    fontFamily = poppins_regular,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )


            }
            Icon(Icons.Filled.ArrowForwardIos, "menu", modifier = Modifier.height(15.dp).width(15.dp), tint = Color.White)   // ok
        }
        Spacer(modifier = Modifier.height(8.dp))




    }


}