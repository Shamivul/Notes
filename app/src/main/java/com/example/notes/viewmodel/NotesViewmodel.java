package com.example.notes.viewmodel;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.notes.modelClass.Note;
import com.example.notes.roomDB.NotesDataBaseClass;

import java.util.List;

public class NotesViewmodel extends ViewModel {

    private static NotesDataBaseClass notesDataBaseClass;

    public LiveData<List<Note>> getNotesLiveData(Context context) {
        notesDataBaseClass = NotesDataBaseClass.getInstance(context);
        return new GetNotesLiveFromDb().doInBackground();
    }

    private static class GetNotesLiveFromDb extends AsyncTask<Void, Void, LiveData<List<Note>>>{

        @Override
        protected LiveData<List<Note>> doInBackground(Void... voids) {
            return notesDataBaseClass.notesDao().fetchAllNotesFromDataBase();
        }
    }
}
