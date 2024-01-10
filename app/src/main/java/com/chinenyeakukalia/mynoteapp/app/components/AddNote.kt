package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNote() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

    ) {
        TextField()
    }
}





