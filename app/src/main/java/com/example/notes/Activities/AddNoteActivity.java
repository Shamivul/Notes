package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notes.R;
import com.example.notes.modelClass.Note;
import com.example.notes.roomDB.NotesDataBaseClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNoteActivity extends AppCompatActivity {

    @BindView(R.id.edit_title_tv)
    EditText editTitleTv;

    @BindView(R.id.add_content_tv)
    EditText editContentTv;

    @BindView(R.id.add_note_tv)
    TextView addNoteTv;

    private static NotesDataBaseClass notesDataBaseClass;
    private static Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ButterKnife.bind(this);

        addNoteTv.setOnClickListener(view -> {
            if (editTitleTv.getText().length() > 0 && editContentTv.getText().length()>0){
                note = new Note();
                note.setTitle(editTitleTv.getText()+"");
                note.setNoteText(editContentTv.getText()+"");
                note.setCreatedAt(new SimpleDateFormat("MMM dd yyyy HH:mm", Locale.getDefault()).format(Calendar.getInstance().getTime()));
                new InsertIntoNotesDatabase(this,note);
            }else {
                Toast.makeText(this,R.string.fill_fields_text,Toast.LENGTH_SHORT).show();
            }

        });

    }

    private static class InsertIntoNotesDatabase extends AsyncTask<Void, Void, Boolean>{

        private Context mContext;
        private Note mNote;

        public InsertIntoNotesDatabase(Context context, Note note) {
            this.mContext = context;
            this.mNote = note;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            notesDataBaseClass.notesDao().insertNote(note);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean){
            }
        }
    }
}
