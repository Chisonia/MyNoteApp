package com.chinenyeakukalia.mynoteapp.app.orientation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import com.chinenyeakukalia.mynoteapp.app.screens.HomeScreen
import com.chinenyeakukalia.mynoteapp.ui.theme.MyNoteAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteAppLandscape(navController: NavController){
    MyNoteAppTheme {
        Surface (color = MaterialTheme.colorScheme.background){
            Row{
                NoteNavigationRail(
                    modifier = Modifier,
                    navController, )
                HomeScreen(
                    modifier = Modifier,
                    navController
                )
            }
        }
    }
}