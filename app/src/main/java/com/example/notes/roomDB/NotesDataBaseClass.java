package com.example.notes.roomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notes.modelClass.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDataBaseClass extends RoomDatabase {

    public abstract NotesDao notesDao();
    private static NotesDataBaseClass notesDataBaseClass;

    public static NotesDataBaseClass getInstance(Context context){
        if (notesDataBaseClass == null){
            notesDataBaseClass = Room.databaseBuilder(context,NotesDataBaseClass.class,"notes_db").build();
        }
        return notesDataBaseClass;
    }

}
