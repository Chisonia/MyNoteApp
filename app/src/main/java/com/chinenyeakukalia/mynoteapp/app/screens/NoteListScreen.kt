package com.chinenyeakukalia.mynoteapp.app.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.chinenyeakukalia.mynoteapp.R
import com.chinenyeakukalia.mynoteapp.app.components.MoreIcon
import com.chinenyeakukalia.mynoteapp.app.components.NoteItem
import com.chinenyeakukalia.mynoteapp.app.components.SearchIcon
import com.chinenyeakukalia.mynoteapp.app.components.componentShape
import com.chinenyeakukalia.mynoteapp.app.navigation.Routes
import com.chinenyeakukalia.mynoteapp.app.view_model.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
    val contentViewModel: NoteViewModel = viewModel()
    val listOfNotes by contentViewModel.getAllNotes().observeAsState(emptyList())
Scaffold (
    topBar = {
        TopAppBar(
            title = { Text(text = "My Pocket Note") },
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            ),
            actions = {
                SearchIcon()
                MoreIcon()
            }
        )
    },
    content = { paddingValues ->
        if(listOfNotes.isEmpty()){
            Box(
                modifier = Modifier
                    .padding(4.dp),
               ){
                Image(
                    painter = painterResource(id = R.drawable.backimage_ng),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize(),
                    alpha = 0.8F
                )
                    Text(
                        text = "Tap the + button to add a new note",
                        color = Color.Blue,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth(0.7f)
                            .background(Color.Transparent),
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                    )
            }

        }else {

            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                items(listOfNotes) { note ->
                    key(note) {
                        NoteItem(
                            note = note,
                            navController = navController
                        )
                    }
                }
            }
        }
    },
    floatingActionButton = {
                           FloatingActionButton(
                               onClick = {navController.navigate(Routes.AddNoteRoute)},
                               modifier = Modifier.padding(4.dp),
                               shape = componentShape.extraLarge,
                               containerColor = MaterialTheme.colorScheme.primary,
                           ) {
                               androidx.compose.material3.Icon(
                                   imageVector = Icons.Default.Add ,
                                   contentDescription = "Add New Note",

                               )

                           }
    },
    floatingActionButtonPosition = FabPosition.Start
)
}

