package org.example.notes2_0.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.notes2_0.NoteStorage;
import org.example.notes2_0.NoteViewAdapter;
import org.example.notes2_0.R;


public class FragmentImportant extends Fragment {

    private NoteStorage storage;
    private NoteViewAdapter adapter;
    private int size;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        storage = NoteStorage.getInstance();
        View view = inflater.inflate(R.layout.fragment_important, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rvImportantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new org.example.notes2_0.NoteViewAdapter(getContext(), storage.getImportantNotes());
        recyclerView.setAdapter(adapter);
        size = adapter.getItemCount();
        return view;
    }
}