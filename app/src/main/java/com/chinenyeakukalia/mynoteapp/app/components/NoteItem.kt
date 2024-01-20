package com.chinenyeakukalia.mynoteapp.app.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
import androidx.compose.material3.SwipeToDismissBoxValue.StartToEnd
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.models.Note
import com.chinenyeakukalia.mynoteapp.app.navigation.Routes
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel
import kotlinx.coroutines.delay
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteItem(note: Note, navController: NavController){
    val noteViewModel: NoteViewModel = viewModel()
    val dismissState = rememberSwipeToDismissBoxState()
    val timestamp = Instant.ofEpochMilli(note.noteTime)
    val noteTime = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault())
    val formattedTime = noteTime.format(DateTimeFormatter.ofPattern("d/M/yyyy, hh:mm a"))
    var undoDelete by remember {mutableStateOf(false)}
    val colorToBeShown by animateColorAsState(
        targetValue = if (dismissState.targetValue == StartToEnd)
        {
            Color.White
        }else{
            Color.White
        },
        label = ""
    )

    if (dismissState.targetValue == StartToEnd){
        LaunchedEffect(key1= "delete") {
            delay(2000)
            if (!undoDelete) {
                noteViewModel.deleteNote(note)
            }
        }
    }
    if (dismissState.targetValue == EndToStart){
        LaunchedEffect(key1= "delete") {
            delay(3000)
            if (!undoDelete) {
                noteViewModel.deleteNote(note)
            }
        }
    }
    if(undoDelete) {
        LaunchedEffect(key1 = "undo") {
            dismissState.reset()
            undoDelete = false
        }
    }

    SwipeToDismissBox(
        state = dismissState,
        backgroundContent = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorToBeShown)
                .padding(horizontal = 8.dp)
        ){
            Button (onClick = { undoDelete = true},
                modifier = Modifier.align(Alignment.CenterEnd)){
                Text(text = "Undo")
            }
        }
    }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    navController.navigate(Routes.noteDetails(note.id.toString()))
                }

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = note.title,
                    fontWeight = FontWeight.Black
                )
                    Text(
                        text = note.noteContent
                    )
                Text(
                    text = formattedTime,
                    color = Color.Blue,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .align(Alignment.End)
                )
            }
        }
    }
}