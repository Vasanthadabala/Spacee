package com.example.spacee.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacee.R

@Composable
fun  BottomBar(navController:NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }

    NavigationBar(
        containerColor = Color(0xFFE4FFD7),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        NavigationBarItem(
            selected = (selectedIndex.value == 1),
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray,
                unselectedIconColor = Color.Transparent,
            ),
            onClick = { navController.navigate(Chat.route){
                popUpTo(Chat.route)
                launchSingleTop = true
            }},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = "Chat",
                    modifier = Modifier.size(28.dp)
                )},
            label = {
                Text(text = "Chats",fontWeight = FontWeight.W400, fontSize = 18.sp)
            },
            alwaysShowLabel = true
        )
        NavigationBarItem(
            selected = (selectedIndex.value == 2),
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Transparent,
                unselectedTextColor = Color.Black
            ),
            onClick = {
                navController.navigate(Call.route){
                    popUpTo(Chat.route)
                    launchSingleTop = true
                }},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.call),
                    contentDescription = "Call",
                    modifier = Modifier.size(28.dp)
                )},
            label = {
                Text(text = "Calls", fontWeight = FontWeight.W400, fontSize = 18.sp)
            },
            alwaysShowLabel = true
        )
        NavigationBarItem(
            selected = (selectedIndex.value == 3),
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Transparent,
                unselectedTextColor = Color.Black
            ),
            onClick = {
                navController.navigate(Settings.route){
                    popUpTo(Chat.route)
                    launchSingleTop = true
                }},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Settings",
                    modifier = Modifier.size(28.dp)
                )},
            label = {
                Text(text = "Settings", fontWeight = FontWeight.W400, fontSize = 18.sp)
            },
            alwaysShowLabel = true
        )
    }
}