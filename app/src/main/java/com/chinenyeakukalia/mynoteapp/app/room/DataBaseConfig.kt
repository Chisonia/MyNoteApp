package com.chinenyeakukalia.mynoteapp.app.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chinenyeakukalia.mynoteapp.app.models.Note

object DataBaseConfig {
    fun getInstance(context: Context): AppDataBase{
        val db = Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "note_db"
        ).build()
        return db
    }
}
@Database(entities = [Note::class], version = 1)
abstract class AppDataBase: RoomDatabase(){
    abstract fun noteDao(): NoteDao
}