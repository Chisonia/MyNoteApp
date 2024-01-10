package com.chinenyeakukalia.mynoteapp.app.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chinenyeakukalia.mynoteapp.app.models.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun saveNote(note: Note)
    @Query("select * from notes")
    fun fetchNotes(): LiveData<List<Note>>
}