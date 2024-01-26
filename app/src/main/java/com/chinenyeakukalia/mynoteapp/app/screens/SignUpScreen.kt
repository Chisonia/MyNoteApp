package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.components.ImageIcons
import com.chinenyeakukalia.mynoteapp.app.components.RememberMe
import com.chinenyeakukalia.mynoteapp.app.components.componentShape
import com.chinenyeakukalia.mynoteapp.app.navigation.Routes

@Composable
fun SignUpScreen(navController: NavController){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    val email by remember { mutableStateOf("") }
    val confirmpass by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Text(
            text = "Hello! Welcome Back,",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp, top = 40.dp, bottom = 4.dp),
        )
        Text(
            text = "Enter your details",
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 30.dp),
        )
        OutlinedTextField(
            value = fullname,
            onValueChange = { fullnameInput -> fullname = fullnameInput },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small),
        )

        OutlinedTextField(
            value = username,
            onValueChange = { usernameInput -> username = usernameInput },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { emailInput -> password = emailInput },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { passwordInput -> password = passwordInput },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )

        OutlinedTextField(
            value = confirmpass,
            onValueChange = { confirmpassInput -> password = confirmpassInput },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )
        RememberMe()
        Button(
            onClick = { navController.navigate(Routes.LoginRoute) },
            modifier = Modifier
                .padding(bottom = 30.dp)

        ) {
            componentShape.medium
            Text(text = "SignUp")
        }
        ImageIcons()
    }
}