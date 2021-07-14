package com.example.noteapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao//he @Dao annotation identifies it as a DAO class for Room.
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) //to make this function SQLite function
    suspend fun insert(note:Note)
    //these function must run in background thread because these are input output operation.
    //I/O opertion are heavy make the app laggy/slow
    //suspend is Kotlin coroutines  // this fuction call in background thread only

    @Delete
    suspend fun delete(note:Note)

    @Query("Select * from Note_table order by id ASC"  )
    fun getAllNotes(): LiveData<List<Note>>
}

// now to have to create Database