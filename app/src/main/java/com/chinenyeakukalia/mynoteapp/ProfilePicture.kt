package com.chinenyeakukalia.mynoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.chinenyeakukalia.mynoteapp.ui.theme.MyNoteAppTheme

class ProfilePictureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNoteAppTheme {
                // Set up your composable content here
                ProfilePictureScreen()
            }
        }
    }
}

@Composable
fun ProfilePictureScreen() {
    Surface(color = MaterialTheme.colorScheme.surfaceContainer) {
        Column {
            // Your other composables can go here

            PickImageButton()
        }
    }
}

@Composable
fun PickImageButton() {
    Button(onClick = { /* Handle button click */ }) {
        // Text displayed on the button
        Text(text = "Pick Image")
    }
}