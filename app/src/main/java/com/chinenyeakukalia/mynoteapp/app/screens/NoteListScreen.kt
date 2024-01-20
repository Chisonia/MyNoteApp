package com.chinenyeakukalia.mynoteapp.app.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.components.MoreIcon
import com.chinenyeakukalia.mynoteapp.app.components.NoteItem
import com.chinenyeakukalia.mynoteapp.app.components.SearchIcon
import com.chinenyeakukalia.mynoteapp.app.navigation.Routes
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
    val contentViewModel: NoteViewModel = viewModel()
    val listOfNotes by contentViewModel.getAllNotes().observeAsState(emptyList())
Scaffold (
    topBar = {
        TopAppBar(
            title = { Text(text = "My Pocket Note") },
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            actions = {
                SearchIcon()
                MoreIcon()
            }
        )
    },
    content = { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                items(listOfNotes) { note ->
                    key(note){
                        NoteItem(
                            note = note,
                            navController = navController
                        )
                    }
                }
            }
    },
    floatingActionButton = {
                           FloatingActionButton(
                               onClick = {navController.navigate(Routes.AddNoteRoute)}
                           ) {
                               androidx.compose.material3.Icon(
                                   imageVector = Icons.Default.Add ,
                                   contentDescription = "Add New Note",

                               )

                           }
    }
)
}

