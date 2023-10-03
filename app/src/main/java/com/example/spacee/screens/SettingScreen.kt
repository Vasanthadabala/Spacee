@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.spacee.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacee.R
import com.example.spacee.navigation.BottomBar
import com.example.spacee.navigation.Profile

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun SettingScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(navController = navController) },
        bottomBar = { BottomBar(navController = navController) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 60.dp)
                .background(Color(0xFFE4FFD7))
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 80.dp)
            ) {
                Text(
                    text = "Settings",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(start = 10.dp, bottom = 20.dp)
                )
                Card(
                    elevation = CardDefaults.cardElevation(5.dp),
                    shape = RoundedCornerShape(15),
                    colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate(Profile.route) })
                {
                    Row {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(80.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.info),
                                contentDescription = "")
                        }
                        Column(
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp)
                        ) {
                            Text(
                                text = "Vasanth",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W500,
                                modifier = Modifier.padding(1.dp)
                            )
                            Text(
                                text = "Hey!, Iam on Sunoo",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500,
                                modifier = Modifier.padding(1.dp)
                            )
                        }
                    }
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(5.dp),
                shape = RoundedCornerShape(15),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate(Profile.route) })
            {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.info),
                            contentDescription = ""
                        )
                    }
                    Column(
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                    ) {
                        Text(
                            text = "About",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                        Text(
                            text = "Version Number,License",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                    }
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(5.dp),
                shape = RoundedCornerShape(15),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate(Profile.route) })
            {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.info),
                            contentDescription = ""
                        )
                    }
                    Column(
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                    ) {
                        Text(
                            text = "About",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                        Text(
                            text = "Version Number,License",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                    }
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(5.dp),
                shape = RoundedCornerShape(15),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate(Profile.route) })
            {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.info),
                            contentDescription = ""
                        )
                    }
                    Column(
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                    ) {
                        Text(
                            text = "About",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                        Text(
                            text = "Version Number,License",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(1.dp)
                        )
                    }
                }
            }

        }
    }
}
    @Composable
    fun TopBar(navController: NavHostController) {
        TopAppBar(
            title = { Text(text = "Settings", fontWeight = FontWeight.W500) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(
                    0xFFE4FFD7
                )
            )
        )
    }
