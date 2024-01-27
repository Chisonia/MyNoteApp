package com.chinenyeakukalia.mynoteapp.app.components

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.chinenyeakukalia.mynoteapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bar(){
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White,
        ),
        actions = {
            IconButton(onClick = {
                Toast
                    .makeText(context, R.string.note_saved, Toast.LENGTH_SHORT)
                    .show()
            },
            ) {
                DoneIcon()
            }
        },
    )
}