@file:OptIn(ExperimentalMaterial3Api::class)

package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.components.DeleteIcon
import com.chinenyeakukalia.mynoteapp.app.components.EditIcon
import com.chinenyeakukalia.mynoteapp.app.models.Note
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteDetailsScreen(navController: NavController, noteId: String) {
    val noteViewModel: NoteViewModel = viewModel()
    val note by noteViewModel.getNote(noteId).observeAsState()
    var title by rememberSaveable { mutableStateOf("") }
    var noteContent by rememberSaveable { mutableStateOf("") }
    var isEditMode by rememberSaveable{mutableStateOf(false)}

    fun activateEditMode(){
        isEditMode = true
        title = note?.title ?: ""
        noteContent = note?.noteContent ?: ""
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Note Details") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
),
                actions = {
                    if(isEditMode) {
                        IconButton(onClick = {
                            val updatedNote: Note = note!!.copy(
                                title = title,
                                noteContent = noteContent
                            )
                            noteViewModel.updateNote(updatedNote)
                            isEditMode = false
                        }) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = "Save note"

                            )
                        }
                    }else{
                        IconButton(onClick = {
                            activateEditMode()
                        }) {
                            EditIcon()
                        }
                    }
                IconButton(onClick = {
                    noteViewModel.deleteNote(note!!)
                    navController.popBackStack()
                }) {
                    DeleteIcon()
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Card(
                modifier = Modifier
                    .padding(12.dp)

            ) {
                if (isEditMode) {
                    OutlinedTextField(
                        value = title ?: "",
                        onValueChange = { value -> title = value },
                        label = { Text("Title") },
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = noteContent ?: "",
                        onValueChange = { value -> noteContent = value },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Note") },
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            containerColor = Color.Transparent
                        )
                    )
                } else {
                    Text(
                        text = note?.title ?: "",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = note?.noteContent ?: "",
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    )
                }


            }
        }
    }
}