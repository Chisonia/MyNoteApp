package com.chinenyeakukalia.mynoteapp.app.components

import android.media.TimedText
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.TimedValue

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTime::class)
@Composable
fun TextField() {
    var title by rememberSaveable { mutableStateOf("") }
    var noteContent by rememberSaveable { mutableStateOf("") }
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