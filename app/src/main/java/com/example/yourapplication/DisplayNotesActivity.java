package com.example.yourapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DisplayNotesActivity extends AppCompatActivity {

    private ListView notesListView;
    private ImageView addnote;
    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_notes);


        addnote = findViewById(R.id.addnote);
        notesListView = findViewById(R.id.notesListView);
        notesList = new ArrayList<>();



        addnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayNotesActivity.this, MainActivity.class));
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("NOTE_TITLE") && intent.hasExtra("NOTE_TEXT")) {
            String title = intent.getStringExtra("NOTE_TITLE");
            String noteText = intent.getStringExtra("NOTE_TEXT");
            String noteWithTitle = title + ": " + noteText;
            notesList.add(noteWithTitle);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(adapter);
    }
}
