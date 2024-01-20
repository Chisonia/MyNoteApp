package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun MoreIcon(){
    IconButton(onClick = {}) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Icon"
        )
    }
}
