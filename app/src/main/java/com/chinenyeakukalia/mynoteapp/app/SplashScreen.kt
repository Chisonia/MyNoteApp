package com.chinenyeakukalia.mynoteapp.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 20.dp)
    ) {
        Text(
            text = "Welcome,",
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        )
        Text(
            text = "Organize to Time and Thought with",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 40.dp)
        )
        Text(
            text = "My Note App",
            fontSize = 60.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 40.dp)
        )
    }
}