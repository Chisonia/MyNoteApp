package com.chinenyeakukalia.mynoteapp.app.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.chinenyeakukalia.mynoteapp.R
import com.chinenyeakukalia.mynoteapp.app.components.DoneIcon
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
                  colors = topAppBarColors(
                      containerColor = Color.Transparent,
                      actionIconContentColor = Color.Black,
                      ),
                  actions = {
                      IconButton(
                          onClick = {
                              if (title.isEmpty() || noteContent.isEmpty()) {
                                  Toast
                                      .makeText(
                                          context,
                                          "Title/Note Content is empty",
                                          Toast.LENGTH_SHORT
                                      )
                                      .show()
                              } else {
                                  Toast
                                      .makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                                      .show()
                              }
                              noteViewModel.saveNote(title, noteContent)
                          },
                      ) {
                          DoneIcon()
                      }
                  },
              )
              Box {
                  Image(
                      painter = painterResource(id = R.drawable.background1_ng),
                      contentDescription = null,
                      contentScale = ContentScale.Fit,
                      modifier = Modifier
                          .fillMaxSize(1f)

                  )
                  Column(
                      modifier = Modifier
                          .padding(8.dp)
                          .fillMaxWidth()

                  ) {
                      OutlinedTextField(
                          label = { Text("Title") },
                          value = title,
                          onValueChange = { titleInput -> title = titleInput },
                          colors = TextFieldDefaults.colors(
                              focusedContainerColor = Color.Transparent,
                              unfocusedContainerColor = Color.Transparent,
                              disabledContainerColor = Color.Transparent,
                              errorContainerColor = Color.Red,
                              selectionColors = TextSelectionColors(
                                  handleColor = Color.Blue,
                                  backgroundColor = Color.LightGray
                              )
                          ),
                          modifier = Modifier
                              .fillMaxWidth()
                              .clip(componentShape.small)
                              .border(0.dp,Color.Transparent)

                      )
                      Row(
                          horizontalArrangement = Arrangement.SpaceBetween,
                          verticalAlignment = Alignment.CenterVertically,
                          modifier = Modifier.fillMaxWidth()
                      )
                      {
                          OutlinedTextField(
                              label = { Text("Note") },
                              value = noteContent,
                              onValueChange = { noteContentInput ->
                                  noteContent = noteContentInput
                              },
                              colors = TextFieldDefaults.colors(
                                  focusedContainerColor = Color.Transparent,
                                  unfocusedContainerColor = Color.Transparent,
                                  disabledContainerColor = Color.Transparent,
                                  errorContainerColor = Color.Red,
                                  selectionColors = TextSelectionColors(
                                      handleColor = Color.Blue,
                                      backgroundColor = Color.LightGray
                                  )
                              ),
                              modifier = Modifier
                                  .fillMaxWidth()
                                  .padding(bottom = 10.dp)
                                  .clip(componentShape.small)
                                  .border(0.dp,Color.Transparent)
                          )
                      }

                  }
              }
          }
      },
  )
}
