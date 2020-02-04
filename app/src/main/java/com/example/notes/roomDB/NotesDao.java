package com.example.notes.roomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notes.modelClass.Note;

import java.util.List;

@Dao
public interface NotesDao {

    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM Note ORDER BY createdAt desc")
    LiveData<List<Note>> fetchAllNotesFromDataBase();

}
