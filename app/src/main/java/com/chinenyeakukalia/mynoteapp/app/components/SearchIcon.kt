package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun SearchIcon(){
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search for notes"
        )
    }
}