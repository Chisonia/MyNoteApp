package com.chinenyeakukalia.mynoteapp.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NewUser(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Don't Have An Account?",
            modifier = Modifier
                .padding(start = 10.dp, bottom = 20.dp)
        )
        TextButton(
            onClick = { navController.navigate(Routes.SignUpRoute) },
            modifier = Modifier
                .padding(bottom = 20.dp)

        ) {
            Text(
                text = "Register",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }
}