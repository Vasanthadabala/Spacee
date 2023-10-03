@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.spacee.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.spacee.authentication.UserData
import com.example.spacee.navigation.Login

@ExperimentalComposeUiApi
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController:NavHostController, userData: UserData, onSignOut:() -> Unit ) {
    var name = remember { mutableStateOf(TextFieldValue("")) }
    var about = remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        topBar = { ProfileTopBar(navController = navController)},
        content = {
            Column(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .fillMaxHeight()
                    .background(Color(0xFFE4FFD7))
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 80.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .size(180.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        AsyncImage(
                            model = userData.profilePictureUrl,
                            contentDescription = "Profile",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    Column {
                        Text(
                            text = "Name",
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(top = 10.dp, start = 14.dp)
                        )
                        OutlinedTextField(
                            value = userData.username.toString(),
                            onValueChange = {},
                            readOnly = true,
                            enabled = false,
                            textStyle = LocalTextStyle.current.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 18.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE4FFD7))
                                .padding(vertical = 12.dp, horizontal = 14.dp),
                            shape = RoundedCornerShape(15),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White
                            )
                        )
                        Text(
                            text = "Email",
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(top = 10.dp, start = 14.dp)
                        )
                        OutlinedTextField(
                            value = "Sample@mail.com",
                            onValueChange = {},
                            readOnly = true,
                            enabled = false,
                            textStyle = LocalTextStyle.current.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 18.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE4FFD7))
                                .padding(vertical = 12.dp, horizontal = 14.dp),
                            shape = RoundedCornerShape(15),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White
                            )
                        )
                        Text(
                            text = "About",
                            textAlign = TextAlign.Start,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(top = 10.dp, start = 14.dp)
                        )
                        OutlinedTextField(
                            value = "Hey!, Iam on Sunoo",
                            onValueChange = {},
                            readOnly = true,
                            enabled = false,
                            textStyle = LocalTextStyle.current.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 18.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE4FFD7))
                                .padding(vertical = 12.dp, horizontal = 14.dp),
                            shape = RoundedCornerShape(15),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White
                            )
                        )
                        Button(
                            onClick = {
                                onSignOut()
                                navController.navigate(Login.route) },
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 5.dp,
                                pressedElevation = 10.dp,
                                disabledElevation = 0.dp
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 35.dp, horizontal = 16.dp),
                            shape = RoundedCornerShape(32),
                            colors = ButtonDefaults.buttonColors(Color.White)
                        ) {
                            Text(
                                text = "Logout", textAlign = TextAlign.Center, fontSize = 24.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                }
            }
        }
    )
}
@Composable
fun ProfileTopBar(navController: NavHostController)
{
    TopAppBar(
        title = { Text(text = "Profile", fontWeight = FontWeight.W500) },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFE4FFD7))
    )
}