package com.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.data.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter{

    ArrayList<Note> items = new ArrayList<Note>();

    int layoutType = 0;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Note item = items.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    static class ViewHolder extends RecyclerView.ViewHolder{
//
//        public  ViewHolder()
//
//
//
//
//    }

}




