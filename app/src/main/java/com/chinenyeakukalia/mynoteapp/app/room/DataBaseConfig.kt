package com.chinenyeakukalia.mynoteapp.app.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.chinenyeakukalia.mynoteapp.app.models.Note

object DataBaseConfig {
    fun getInstance(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "note_db"
        ).fallbackToDestructiveMigration().build()
    }
}
@Database(entities = [Note::class], version = 2)
abstract class AppDataBase: RoomDatabase(){
    abstract fun noteDao(): NoteDao

}