package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.sp
import com.chinenyeakukalia.mynoteapp.app.components.ImageIcons
import com.chinenyeakukalia.mynoteapp.app.MyTextFields

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun LoginScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Text(
            text = "Hello! Welcome Back,",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
        )
        Text(
            text = "Enter your details",
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        MyTextFields()
        RememberMe()
        Button(onClick = {}) {
            Text(text = "Login")
        }
        ImageIcons()
    }
}


@Composable
fun RememberMe(){
    var isChecked by remember{ mutableStateOf( false)}
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Remember Me")
        Switch(
            checked = isChecked,
            onCheckedChange = {isChecked = !isChecked}
        )
    }
}