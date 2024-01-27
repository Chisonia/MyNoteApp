package com.chinenyeakukalia.mynoteapp.app.orientation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.screens.HomeScreen
import com.chinenyeakukalia.mynoteapp.ui.theme.MyNoteAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteAppPortrait(navController: NavController){
    MyNoteAppTheme  {
        Scaffold(
            bottomBar = { NoteBottomNavigation(modifier = Modifier,
                navController) }
        ){ padding ->
            HomeScreen(Modifier.padding(padding), navController)
        }
    }
}
