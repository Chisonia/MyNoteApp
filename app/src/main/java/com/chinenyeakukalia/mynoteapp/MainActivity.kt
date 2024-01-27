package com.chinenyeakukalia.mynoteapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chinenyeakukalia.mynoteapp.app.NoteApp
import com.chinenyeakukalia.mynoteapp.app.components.Routes
import com.chinenyeakukalia.mynoteapp.app.screens.AddNoteScreen
import com.chinenyeakukalia.mynoteapp.app.screens.LoginScreen
import com.chinenyeakukalia.mynoteapp.app.screens.NoteDetailsScreen
import com.chinenyeakukalia.mynoteapp.app.screens.ResetPasswordScreen
import com.chinenyeakukalia.mynoteapp.app.screens.SignUpScreen
import com.chinenyeakukalia.mynoteapp.app.screens.UserProfileScreen
import com.chinenyeakukalia.mynoteapp.app.view_model.AuthViewModel
import com.chinenyeakukalia.mynoteapp.ui.theme.MyNoteAppTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyNoteAppTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val authViewModel: AuthViewModel = viewModel()
                    val error by rememberSaveable { authViewModel.errorMessage }
                    val windowSizeClass = calculateWindowSizeClass( this)
                    val isUserSignIn by rememberSaveable {authViewModel.isUserAuthenticated}
                    val navController = rememberNavController()
                    if(error.isNotEmpty()){
                        val context = LocalContext.current
                        Toast
                            .makeText(context, error, Toast.LENGTH_SHORT)
                            .show()
                        authViewModel.clearErrorMessage()
                    }

                    NavHost(
                        navController = navController,
                        startDestination =
                        if(isUserSignIn) {
                            Routes.NoteListRoute
                        } else {
                            Routes.LoginRoute
                        }
                    ) {
                        /*composable(Routes.SignUpRoute) {
                            SplashScreen(navController)
                        }*/
                        composable(Routes.SignUpRoute) {
                            SignUpScreen(navController, authViewModel)
                        }
                        composable(Routes.LoginRoute) {
                            LoginScreen(navController, authViewModel)
                        }
                        composable(Routes.ResetPasswordRoute) {
                            ResetPasswordScreen(navController, authViewModel)
                        }
                        composable(Routes.NoteListRoute) {
                            NoteApp(windowSizeClass, navController)
                        }
                        composable(Routes.ProfileRoute) {
                            val firebaseUser = Firebase.auth.currentUser
                            val userName = firebaseUser?.displayName ?: "User" // Provide a default name if the user's name is not available
                            val onProfilePictureClick: () -> Unit = {
                                navController.navigate(Routes.ProfileRoute)
                            }
                            UserProfileScreen(
                                userName = userName,
                                profilePictureUrl = null,
                                onProfilePictureClick = onProfilePictureClick,
                                authViewModel = authViewModel
                            )
                        }
                        composable(Routes.AddNoteRoute) {
                            AddNoteScreen(navController)
                        }
                        composable("note-details/{noteId}") {
                            NoteDetailsScreen(
                                navController = navController,
                                noteId = it.arguments!!.getString("noteId")!!
                            )
                        }
                    }
                }
            }
        }
    }
}
