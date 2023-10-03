package com.example.spacee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spacee.authentication.GoogleAuthUiClient
import com.example.spacee.authentication.SignInViewModel
import com.example.spacee.navigation.Call
import com.example.spacee.navigation.Chat
import com.example.spacee.navigation.Login
import com.example.spacee.navigation.Profile
import com.example.spacee.navigation.Settings
import com.example.spacee.screens.CallScreen
import com.example.spacee.screens.ChatScreen
import com.example.spacee.screens.LoginScreen
import com.example.spacee.screens.ProfileScreen
import com.example.spacee.screens.SettingScreen
import com.example.spacee.ui.theme.SpaceeTheme
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Login.route)
                    {
                        composable(Login.route)
                        {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if (googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate(Chat.route)
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if (state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()
                                    navController.navigate(Chat.route)
                                    viewModel.resetState()
                                }
                            }

                            LoginScreen(
                                navController,
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                        composable(Chat.route)
                        {
                            ChatScreen(navController)
                        }
                        composable(Call.route)
                        {
                            CallScreen(navController)
                        }
                        composable(Profile.route)
                        {
                            val signedInUser = googleAuthUiClient.getSignedInUser()
                            if (signedInUser != null) {
                                ProfileScreen(
                                    navController,
                                    userData = signedInUser,
                                    onSignOut = {
                                        lifecycleScope.launch {
                                            googleAuthUiClient.signOut()
                                            Toast.makeText(
                                                applicationContext,
                                                "Signed out",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            navController.popBackStack()
                                        }
                                    }
                                )
                            }
                        }
                        composable(Settings.route)
                        {
                            val signedInUser = googleAuthUiClient.getSignedInUser()
                            if (signedInUser != null) {
                                SettingScreen(
                                    navController,
                                    signedInUser
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}