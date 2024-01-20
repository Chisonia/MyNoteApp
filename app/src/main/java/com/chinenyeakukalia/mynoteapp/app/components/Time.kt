package com.chinenyeakukalia.mynoteapp.app.components

import android.icu.text.DateFormat.getDateTimeInstance
import android.icu.text.SimpleDateFormat
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.util.Date

@Composable
fun DisplayTextClock(){
    val sdf = getDateTimeInstance()
    val currentDateAndTime = sdf.format(Date())
    Text(
        text = currentDateAndTime
    )
}