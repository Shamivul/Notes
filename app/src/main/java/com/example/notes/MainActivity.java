package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.example.notes.Activities.AddNoteActivity;
import com.example.notes.Activities.ViewNoteActivity;
import com.example.notes.Adapter.NoteItemAdapter;
import com.example.notes.modelClass.Note;
import com.example.notes.viewmodel.NotesViewmodel;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity implements NoteItemAdapter.OnNoteClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.notes_item_recycler_view)
    RecyclerView notesRecyclerView;

    @BindView(R.id.new_note_tv)
    TextView newNoteTv;

    private ArrayList<Note> noteArrayList = new ArrayList<>();
    private NoteItemAdapter noteItemAdapter;
    private NotesViewmodel notesViewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setAdapterRecyclerView();

        notesViewmodel = ViewModelProviders.of(this).get(NotesViewmodel.class);

        getAllNoteNotesFromDatabase();

        newNoteTv.setOnClickListener(view -> gotoNewNoteActivity());
    }

    private void getAllNoteNotesFromDatabase() {
        notesViewmodel.getNotesLiveData(this).observe(this, notes -> {
            noteArrayList.clear();
            noteArrayList.addAll(notes);
            Log.d(TAG, "getAllNoteNotesFromDatabase: "+notes.size());
            noteItemAdapter.notifyDataSetChanged();
        });
    }

    //go to AddNoteActivity to add new Note
    private void gotoNewNoteActivity() {
        startActivity(new Intent(new Intent(this, AddNoteActivity.class)));
    }

    //Setting adapter and layout manager to recycler
    private void setAdapterRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        noteItemAdapter = new NoteItemAdapter(this,noteArrayList);

        notesRecyclerView.setLayoutManager(layoutManager);
        notesRecyclerView.setAdapter(noteItemAdapter);

    }

    @Override
    public void onNoteClick(Note note) {
        Log.d(TAG, "onNoteClick: "+note);
        Intent intent = new Intent(this, ViewNoteActivity.class);
        intent.putExtra("note",note);
        startActivity(intent);
    }
}
