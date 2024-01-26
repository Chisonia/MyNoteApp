package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RememberMe(){
    var isChecked by remember{ mutableStateOf( false) }
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Remember Me",
            modifier = Modifier
                .padding(start = 10.dp, bottom = 20.dp)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = {isChecked = !isChecked},
            modifier = Modifier
                .padding(start = 10.dp, bottom = 20.dp)
        )
    }
}