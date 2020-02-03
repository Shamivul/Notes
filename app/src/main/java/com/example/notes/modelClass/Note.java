package com.example.notes.modelClass;

public class Note {

    //vars
    private String title;
    private String noteText;
    private String createdAt;

    //Constructor to set objects Manually
    public Note(String title, String noteText, String createdAt) {
        this.title = title;
        this.noteText = noteText;
        this.createdAt = createdAt;
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
}
