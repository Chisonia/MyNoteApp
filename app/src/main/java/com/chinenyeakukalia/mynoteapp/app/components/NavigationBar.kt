package com.chinenyeakukalia.mynoteapp.app.components

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
        startDestination = "note-list"
    ){
        composable("note-list"){
            NoteListScreen(navController)
        }
        composable("add-note"){
            AddNoteScreen()
        }
    }
}