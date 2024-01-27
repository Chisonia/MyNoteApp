package com.chinenyeakukalia.mynoteapp.app.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.R
import com.chinenyeakukalia.mynoteapp.app.components.RememberPassword
import com.chinenyeakukalia.mynoteapp.app.components.Routes
import com.chinenyeakukalia.mynoteapp.app.components.componentShape
import com.chinenyeakukalia.mynoteapp.app.view_model.AuthViewModel

@Composable
fun ResetPasswordScreen(navController: NavController, authViewModel: AuthViewModel){
    val context = LocalContext.current
    var areFieldsFilled by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(all = 10.dp)
    ) {
        Text(
            text = "Enter Your Email",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(top = 40.dp, bottom = 30.dp)
                .fillMaxWidth(),
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                areFieldsFilled = email.isNotEmpty()
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
                .clip(componentShape.small)
        )
        Button(
            onClick = {
                if(email.isEmpty()) {
                    Toast
                        .makeText(
                            context,
                            (R.string.valid_email_error_message),
                            Toast.LENGTH_SHORT
                        )
                        .show()
                } else {
                    Toast
                        .makeText(context,
                            (R.string.reset_success_message), Toast.LENGTH_SHORT)
                        .show()
                }
                authViewModel.resetPassword(email)
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
            Text(text = "Reset Password")
        }
        Spacer (
            modifier = Modifier.height(10.dp)
        )
        RememberPassword(navController)
    }
}