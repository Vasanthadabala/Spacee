package com.example.spacee.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spacee.navigation.BottomBar
import com.example.spacee.navigation.Categories
import com.example.spacee.navigation.Profile

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun ChatScreen(navController: NavHostController)
{
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
    ) {
        HomeScreen(navController)
    }
}


@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(navController: NavHostController)
{
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        TextField(
            singleLine = true,
            value = searchText,
            onValueChange = { newText -> searchText = newText},
            leadingIcon = {
                Box(modifier = Modifier.padding(start = 10.dp),
                    contentAlignment = Alignment.Center){
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier.size(28.dp))}},
            trailingIcon = {
                Box(modifier = Modifier.padding(end = 10.dp),
                    contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "",
                        modifier = Modifier.size(40.dp).
                        clickable { navController.navigate(Profile.route) })
                }},
            shape = RoundedCornerShape(50),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color(0xFFE4FFD7)
            ),
            placeholder = { Text(text = "Search")},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
                .size(60.dp),
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp, start = 10.dp, end = 10.dp))
        {
            items(Categories){
                    item -> CategoryMenu(item)
            }
        }
        LazyColumn(){}
    }
}
@Composable
fun CategoryMenu(category:String)
{
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(Color.White),
        shape = RoundedCornerShape(28),
        modifier = Modifier
            .padding(5.dp)
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(28))
            .height(36.dp)
    ) {
        Text(text = category, color = Color.Black)
    }
}