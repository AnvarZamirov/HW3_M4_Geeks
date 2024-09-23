package com.example.noteapp.data.db.daos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.data.db.daos.NoteDao
import com.example.noteapp.data.models.NoteModel

@Database(entities = [NoteModel:: class], version = 4)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}