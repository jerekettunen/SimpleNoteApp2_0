package org.example.notes2_0.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import org.example.notes2_0.MainActivity;
import org.example.notes2_0.Note;
import org.example.notes2_0.NoteStorage;
import org.example.notes2_0.R;

import java.time.Instant;


public class FragmentAdd extends Fragment {
    private int pos;
    private EditText title, details;
    private Switch aSwitch;
    private long timestamp;
    private Note note;
    public FragmentAdd() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("In add");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        pos = -1;
        title = view.findViewById(R.id.txtNoteTitle);
        details = view.findViewById(R.id.txtNoteDetails);
        aSwitch = view.findViewById(R.id.swImportant);

        if (getArguments() != null) {
            pos = getArguments().getInt("position",-1);
        }

        if (pos > -1){
            note = NoteStorage.getInstance().getNote(pos);
            title.setText(note.getTitle());
            details.setText(note.getDetails());
        }

        Button saveButton = view.findViewById(R.id.btnAddNote);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pos == -1) {
                    timestamp = Instant.now().getEpochSecond();
                    Note note = new Note(title.getText().toString(), details.getText().toString(), timestamp, aSwitch.isChecked());
                    NoteStorage.getInstance().addNote(note);
                } else {
                    note.setTitle(title.getText().toString());
                    note.setDetails(details.getText().toString());
                }
                title.setText("");
                details.setText("");
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        title.setText("");
        details.setText("");
        pos = -1;
    }
}