package com.chinenyeakukalia.mynoteapp.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.components.AlreadyHaveAccount
import com.chinenyeakukalia.mynoteapp.app.components.ImageIcons
import com.chinenyeakukalia.mynoteapp.app.components.RememberMe
import com.chinenyeakukalia.mynoteapp.app.components.componentShape
import com.chinenyeakukalia.mynoteapp.app.view_model.AuthViewModel

@Composable
fun SignUpScreen(navController: NavController, authViewModel: AuthViewModel){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var userEmail by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false)}
    var areFieldsFilled by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Text(
            text = "Hello!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 40.dp, bottom = 4.dp),
        )
        Text(
            text = "Create Account",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 30.dp),
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username  = it
                areFieldsFilled = userEmail.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()
                            },
            label = { Text("Username") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "User Icon",
                    tint = Color.Gray // Adjust the tint color as needed
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Red,
                selectionColors = TextSelectionColors(
                    handleColor = Color.Blue,
                    backgroundColor = Color.LightGray
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )

        OutlinedTextField(
            value = userEmail,
            onValueChange = {
                userEmail = it
                areFieldsFilled = userEmail.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()
                            },
            label = { Text("Email") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email Icon",
                    tint = Color.Gray // Adjust the tint color as needed
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Red,
                selectionColors = TextSelectionColors(
                    handleColor = Color.Blue,
                    backgroundColor = Color.LightGray
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                areFieldsFilled = userEmail.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty() },
            label = { Text("Password") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "User Icon",
                    tint = Color.Gray // Adjust the tint color as needed
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) {
                            Icons.Default.VisibilityOff
                        } else
                        {
                            Icons.Default.Visibility
                        },
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
            visualTransformation = if (passwordVisible)
            {
                VisualTransformation.None
            } else
            {
                PasswordVisualTransformation()
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Red,
                selectionColors = TextSelectionColors(
                    handleColor = Color.Blue,
                    backgroundColor = Color.LightGray
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(componentShape.small)
        )
        RememberMe()
        Button(
            onClick = { authViewModel.registerUser(
                username = username,
                email = userEmail,
                password = password)
                      },
            enabled = areFieldsFilled,
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                disabledContainerColor = MaterialTheme.colorScheme.tertiary,
                disabledContentColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .fillMaxWidth()

        ) {
            componentShape.medium
            Text(text = "Sign Up")
        }
        ImageIcons()
        Spacer (
            modifier = Modifier.height(20.dp)
        )
        AlreadyHaveAccount(navController)
    }
}