package com.chinenyeakukalia.mynoteapp.app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.app.orientation.NoteAppLandscape
import com.chinenyeakukalia.mynoteapp.app.orientation.NoteAppPortrait

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteApp(windowSize: WindowSizeClass, navController: NavController){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            NoteAppPortrait(navController)
        }
        WindowWidthSizeClass.Expanded -> {
            NoteAppLandscape(navController)
        }
    }
}