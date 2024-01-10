package com.chinenyeakukalia.mynoteapp.app.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.chinenyeakukalia.mynoteapp.app.models.Note
import com.chinenyeakukalia.mynoteapp.app.room.DataBaseConfig
import kotlinx.coroutines.launch

class NoteViewModel(val app: Application) : AndroidViewModel(app) {
    private val db = DataBaseConfig.getInstance(app)
    fun saveNote(title: String, noteContent:  String){
        //Creating a note instance
        val note = Note(
            title = title,
            noteContent = noteContent
        )

        viewModelScope.launch {
            //Calling the save function of the database
            db.noteDao().saveNote(note)
        }
    }

    fun getAllNotes(): LiveData<List<Note>>{
        //Calling the fetchNote function of the database
        return db.noteDao().fetchNotes()
    }
}