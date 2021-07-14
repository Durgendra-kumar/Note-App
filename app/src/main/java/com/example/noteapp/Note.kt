package com.example.noteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//entity annotation create table of this class in SQLite
@Entity(tableName = "Note_table")
// text and id are the column of the table in SQLite
class Note(@ColumnInfo(name="note_text") val text: String) {
    @PrimaryKey(autoGenerate = true) var id: Int=0
}
//now the table in SQLite in created, to acces the data from table we have to create DAO(data access object)