package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chinenyeakukalia.mynoteapp.R

@Composable
fun ImageIcons(){

    Row (
        horizontalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Image(
            painter = painterResource(id = R.drawable.goog_ng),
            contentDescription = "Clickable Google Icon",
            modifier = Modifier
                .size(width = 18.dp, height = 18.dp)
                .padding(4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.face_ng),
            contentDescription = "Clickable Facebook Icon",
            modifier = Modifier
                .size(width = 18.dp, height = 18.dp)
                .padding(4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.appl_ng),
            contentDescription = "Clickable Apple Icon",
            modifier = Modifier
                .size(width = 18.dp, height = 18.dp)
                .padding(4.dp)
        )
    }
}




