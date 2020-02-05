package com.example.notes.modelClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Note implements Serializable {

    //vars
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "noteText")
    private String noteText;

    @ColumnInfo(name = "createdAt")
    private String createdAt;

    //Constructor to set objects Manually
    public Note(String title, String noteText, String createdAt) {
        this.title = title;
        this.noteText = noteText;
        this.createdAt = createdAt;
    }

    //creating null object
    public Note() {

    }

    //attr getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
