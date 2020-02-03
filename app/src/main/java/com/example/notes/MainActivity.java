package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notes.modelClass.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.notes_item_recycler_view)
    RecyclerView notesRecyclerView;

    //vars
    private ArrayList<Note> noteArrayList = new ArrayList<>();
    private NoteItemAdapter noteItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setAdapterRecyclerView();

        addItemToNotesList();
    }

    //add items to the list
    private void addItemToNotesList() {
        noteArrayList.add(new Note("My Essay","One of the oldest civilisations in the world, India is a mosaic of multicultural experiences.\n" +
                " With a rich heritage and myriad attractions, the country is among the most popular tourist destinations in the world. It covers an area of 32, 87,263 sq. km, \n" +
                "extending from the snow-covered Himalayan heights to the tropical rain forests of the south. As the 7th largest country in the world, India stands apart from the rest of Asia, marked off as it is by mountains and the sea,\n"+
                "which give the country a distinct geographical entity.\n",getCurrentTimeInFormat()));
        noteArrayList.add(new Note("My Essay","One of the oldest civilisations in the world, India is a mosaic of multicultural experiences.\n" +
                " With a rich heritage and myriad attractions, the country is among the most popular tourist destinations in the world. It covers an area of 32, 87,263 sq. km, \n" +
                "extending from the snow-covered Himalayan heights to the tropical rain forests of the south. As the 7th largest country in the world, India stands apart from the rest of Asia, marked off as it is by mountains and the sea,\n"+
                "which give the country a distinct geographical entity.\n",getCurrentTimeInFormat()));
        noteArrayList.add(new Note("My Essay","One of the oldest civilisations in the world, India is a mosaic of multicultural experiences.\n" +
                " With a rich heritage and myriad attractions, the country is among the most popular tourist destinations in the world. It covers an area of 32, 87,263 sq. km, \n" +
                "extending from the snow-covered Himalayan heights to the tropical rain forests of the south. As the 7th largest country in the world, India stands apart from the rest of Asia, marked off as it is by mountains and the sea,\n"+
                "which give the country a distinct geographical entity.\n",getCurrentTimeInFormat()));

        //notify the adapter that items has been changed
        noteItemAdapter.notifyDataSetChanged();
    }

    //get current time and converting it to a format
    private String getCurrentTimeInFormat() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm",Locale.getDefault());
        return dateFormat.format(date);
    }

    //Setting adapter and layout manager to recycler
    private void setAdapterRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        noteItemAdapter = new NoteItemAdapter(this,noteArrayList);

        notesRecyclerView.setLayoutManager(layoutManager);
        notesRecyclerView.setAdapter(noteItemAdapter);

    }
}
