package com.example.notes.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.notes.R;
import com.example.notes.modelClass.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewNoteActivity extends AppCompatActivity {

    private static final String TAG = ViewNoteActivity.class.getSimpleName();


    @BindView(R.id.view_note_title_tv)
    TextView viewNoteTitleTv;

    @BindView(R.id.view_note_content_tv)
    TextView viewNoteEditTv;

    @BindView(R.id.header_title)
    TextView headerTitleTv;

    private Note note = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        ButterKnife.bind(this);

        note = (Note) getIntent().getSerializableExtra("note");

        Log.d(TAG, "onCreate: "+note);

        setNoteView();

        headerTitleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setNoteView() {
        viewNoteTitleTv.setText(note.getTitle());
        viewNoteEditTv.setText(note.getNoteText());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
