package com.chinenyeakukalia.mynoteapp.app.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chinenyeakukalia.mynoteapp.app.screens.AddNoteScreen
import com.chinenyeakukalia.mynoteapp.app.screens.LoginScreen
import com.chinenyeakukalia.mynoteapp.app.screens.NoteDetailsScreen
import com.chinenyeakukalia.mynoteapp.app.screens.NoteListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.LoginRoute
    ) {
        composable(Routes.LoginRoute) {
            LoginScreen(navController)
        }
        composable(Routes.NoteListRoute) {
            NoteListScreen(navController)
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

object Routes {
        val LoginRoute = "login"
        val NoteListRoute = "note-list"
        val AddNoteRoute = "add-note"
    fun noteDetails(noteId: String): String{
        return "note-details/$noteId"
    }
}