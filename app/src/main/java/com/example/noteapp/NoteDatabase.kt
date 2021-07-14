package com.example.noteapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// we have to make this class singleton because ek hi instance multiple jagah se use ho raha ho

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {

    //cannot make object of this class
    //children ka object bana sakte hai;
    abstract fun getNoteDao(): NoteDao

    // to make this Singleton
    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {//synchronise is used to make it thread safe //koi or thread  id time pr is block to acces na kare
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}