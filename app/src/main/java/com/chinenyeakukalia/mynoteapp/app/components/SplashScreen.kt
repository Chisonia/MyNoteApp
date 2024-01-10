package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chinenyeakukalia.mynoteapp.R

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 20.dp)
    ) {
        Image(
            painter =  painterResource(id = R.drawable.notebookicon_ng),
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.None,
            alpha = 0.8F )
        Text(
            text = "My Pocket Note",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
        )
    }
}