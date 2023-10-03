package com.example.spacee.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spacee.authentication.SignInState

@Composable
fun LoginScreen(navController: NavHostController, state : SignInState, onSignInClick : ()-> Unit)
{
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError){
        state.signInError?.let { err ->
            Toast.makeText( context,err, Toast.LENGTH_LONG ).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(Color(0xFFE4FFD7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(
            onClick = {onSignInClick()},
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp,
                pressedElevation = 10.dp,
                disabledElevation = 0.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            shape = RoundedCornerShape(32),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = "Login", textAlign = TextAlign.Center, fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}