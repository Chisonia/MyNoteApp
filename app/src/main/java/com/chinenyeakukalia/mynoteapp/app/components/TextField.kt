package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(){
    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    OutlinedTextField(
        value = title,
        onValueChange = { topicInput -> title = topicInput },
        label = { Text( "Title of the note") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clip(componentShape.small),
    )
    Row() {
        OutlinedTextField(
            value = note,
            onValueChange = { noteInput -> note = noteInput },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )
    }

}