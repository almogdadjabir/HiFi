package com.almogdadjabir.hifi.view.singin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.almogdadjabir.hifi.R
import com.almogdadjabir.hifi.ui.theme.dark
import com.almogdadjabir.hifi.ui.theme.darkLight
import com.almogdadjabir.hifi.ui.theme.darkx2
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnrememberedGetBackStackEntry")
@ExperimentalCoilApi
@Composable
fun SingIn(
    navHostController: NavHostController,
) {
    var username by remember {
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    var isPasswordVisable by remember {
        mutableStateOf(false)
    }

    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length > 1
    }

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = dark
    )

    Scaffold(backgroundColor = dark) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            Image(
                painter = painterResource(id = R.drawable.ic__animal_ears_hat_layer_photo_icon),
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .size(180.dp),
//                colorFilter = ColorFilter.tint(Color.White)
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp),
                backgroundColor = dark,
                elevation = 2.dp

            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(32.dp)) {
                    Text(
                        text = "Hello Again!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Welcome back you've \n been missed!",
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color(0xFFf2f2f2)
                    )
                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.weight(1f))

                        OutlinedTextField(
                            value = username,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { username = it },
                            label = {Text(text = "Username")},
                            singleLine = true,
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                cursorColor = Color.White,
                                disabledLabelColor = Color.White,
                                focusedIndicatorColor = Color(0xFFf2f2f2),
                                unfocusedIndicatorColor = Color(0xFFf2f2f2),
                                focusedLabelColor = Color(0xFFf2f2f2),
                                unfocusedLabelColor = Color(0xFFf2f2f2),
                            ),
                            trailingIcon = {
                                if (username.isNotBlank())
                                    IconButton(onClick = {username = ""}) {
                                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "")

                                    }
                            }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = password,
                            modifier = Modifier.fillMaxWidth(),
                            onValueChange = { password = it },
                            singleLine = true,
                            label = {Text(text = "Password")},
                            shape = RoundedCornerShape(8.dp),
                            colors = TextFieldDefaults.textFieldColors(
                                cursorColor = Color.White,
                                disabledLabelColor = Color.White,
                                focusedIndicatorColor = Color(0xFFf2f2f2),
                                unfocusedIndicatorColor = Color(0xFFf2f2f2),
                                focusedLabelColor = Color(0xFFf2f2f2),
                                unfocusedLabelColor = Color(0xFFf2f2f2),
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                            visualTransformation = if (isPasswordVisable) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(
                                    onClick = { isPasswordVisable = !isPasswordVisable }) {
                                    Icon(imageVector =
                                    if(isPasswordVisable) Icons.Default.Visibility else Icons.Default.VisibilityOff ,
                                        contentDescription = "",
                                        tint = Color(0xFFf2f2f2)
                                    )
                                }
                            }
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                navHostController.navigate("Home")
                            },
                            enabled = isFormValid,
                            modifier = Modifier.fillMaxWidth() .defaultMinSize(minHeight = 45.dp),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Log In")
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            TextButton(
                                onClick = {
                                navHostController.navigate("SingUp")

                            },
                            ) {
                                Text(text = "Sing Up", color = Color.White)
                            }

                            TextButton(onClick = {}) {
                                Text(text = "Forget Password?", color = Color.Gray)

                            }
                        }


                    }
                }


            }
        }

    }
}

