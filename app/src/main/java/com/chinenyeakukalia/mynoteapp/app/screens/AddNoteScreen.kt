package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chinenyeakukalia.mynoteapp.app.components.AddNote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(){
  Scaffold(
      topBar = {
          TopAppBar(
              title = { Text(text = "Add Note") },
              colors = TopAppBarDefaults.smallTopAppBarColors(
                  containerColor = MaterialTheme.colorScheme.tertiary,
                  titleContentColor = Color.White,
                  actionIconContentColor = Color.White
              ),
              actions = {
                  IconButton(onClick = {}) {
                      androidx.compose.material3.Icon(
                          imageVector = Icons.Default.Close,
                          contentDescription = "Close note"
                      )
                  }
              }
          )
      },
      content = { paddingValues ->
          Column(
              modifier = Modifier
                  .padding(paddingValues)
                  .fillMaxSize()
          ) {
              AddNote()
          }
      },
  )
}
