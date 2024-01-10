package com.chinenyeakukalia.mynoteapp.app.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.chinenyeakukalia.mynoteapp.R
import com.chinenyeakukalia.mynoteapp.app.components.TopBar
import com.chinenyeakukalia.mynoteapp.app.components.componentShape
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(navController: NavHostController) {
    val context = LocalContext.current
    val noteViewModel: NoteViewModel = viewModel()
    var title by rememberSaveable { mutableStateOf("") }
    var noteContent by rememberSaveable { mutableStateOf("") }
  Scaffold(
      topBar = {
          TopBar(navController)
      },
      content = { paddingValues ->
          Column(
              modifier = Modifier
                  .padding(paddingValues)
                  .fillMaxSize()
          ) {
              TopAppBar(
                  title = { Text(text = "") },
                  colors = TopAppBarDefaults.smallTopAppBarColors(
                      containerColor = MaterialTheme.colorScheme.tertiary,
                      titleContentColor = Color.White,
                      actionIconContentColor = Color.White,
                  ),
                  actions = {
                      IconButton(onClick = {
                          Toast
                              .makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                              .show()
                          noteViewModel.saveNote(title, noteContent)
                      },
                      ) {
                          Icon(
                              imageVector = Icons.Default.Done,
                              contentDescription = "Done",
                          )
                      }
                  },
              )
              Column(
                  modifier = Modifier
                      .padding(8.dp)
                      .fillMaxWidth()

              ){
                  OutlinedTextField(
                      label = { Text("Add Title") },
                      value = title,
                      onValueChange = { titleInput -> title = titleInput },
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(bottom = 0.dp)
                          .clip(componentShape.small),
                  )
                  Row(
                      horizontalArrangement = Arrangement.SpaceBetween,
                      verticalAlignment = Alignment.CenterVertically,
                      modifier = Modifier.fillMaxWidth()
                  )
                  {
                      OutlinedTextField(
                          label = { Text("Notes") },
                          value = noteContent,
                          onValueChange = { noteContentInput -> noteContent = noteContentInput },
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(bottom = 10.dp)
                              .clip(componentShape.small),
                      )
                  }

              }
          }
      },
  )
}
