package com.chinenyeakukalia.mynoteapp.app.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.chinenyeakukalia.mynoteapp.app.models.Note
import com.chinenyeakukalia.mynoteapp.app.room.DataBaseConfig
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch
import java.util.Calendar

class NoteViewModel(val app: Application) : AndroidViewModel(app) {
    private val db = DataBaseConfig.getInstance(app)
    private  fun getStartedDay(currentTimeMills: Long): Long{
        val calendar = Calendar.getInstance().apply{
            timeInMillis = currentTimeMills
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE,0)
            set(Calendar.SECOND,0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }

    fun saveNote(title: String, noteContent: String){
        if(title.isEmpty() || noteContent.isEmpty())return
        //Creating a note instance
        val currentTimeMillis = System.currentTimeMillis()
        val note = Note(
            title = title,
            noteContent = noteContent,
            noteTime = currentTimeMillis

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

    fun getNote(noteId: String): LiveData<Note> {
        return db.noteDao().fetchNote(noteId)
    }
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            db.noteDao().deleteNote(note)
        }
    }
    fun updateNote(note: Note) {
        viewModelScope.launch {
            db.noteDao().updateNote(note)
        }
    }
}