package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun DeleteIcon(){
    Icon(
        imageVector = Icons.Default.Delete,
        contentDescription = "Delete Button"
    )
}