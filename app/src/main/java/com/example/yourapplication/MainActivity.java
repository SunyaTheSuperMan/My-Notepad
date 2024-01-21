package com.example.yourapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText noteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.titleEditText);
        noteEditText = findViewById(R.id.noteEditText);
    }

    public void saveNote(View view) {
        String title = titleEditText.getText().toString();
        String noteText = noteEditText.getText().toString();

        if (!title.isEmpty() && !noteText.isEmpty()) {
            Intent intent = new Intent(this, DisplayNotesActivity.class);
            intent.putExtra("NOTE_TITLE", title);
            intent.putExtra("NOTE_TEXT", noteText);
            startActivity(intent);
        }
    }
}
