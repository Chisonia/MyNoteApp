package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun BackArrow(){
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back Button"
    )
}