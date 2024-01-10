package com.chinenyeakukalia.mynoteapp.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chinenyeakukalia.mynoteapp.app.screens.AddNoteScreen
import com.chinenyeakukalia.mynoteapp.app.screens.NoteListScreen

@Composable
fun AppNavigation(){
val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute) {
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
    }
}

object Routes{
    val NoteListRoute = "note list"
    val AddNoteRoute = "add-note"

}