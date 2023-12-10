package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.R
import com.chinenyeakukalia.mynoteapp.app.components.NoteItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
Scaffold (
    topBar = {
        TopAppBar(
            title = { Text(text = "My Pocket Note") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            actions = {
                IconButton(onClick = {}) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search for notes"
                    )
                }
                IconButton(onClick = {}) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More Icon"
                    )
                }
            }
        )
    },
    floatingActionButton = {
                           FloatingActionButton(onClick = {navController.navigate("add-note")}) {
                               androidx.compose.material3.Icon(
                                   imageVector = Icons.Default.Add ,
                                   contentDescription = "Add New Note",
                               )
                           }
    },
    content = {paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ){
            Image(
                painter =  painterResource(id = R.drawable.backimage_ng),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                alpha = 0.8F )
        }
    }
)
}

