package com.service;

import android.view.View;

import com.adapter.NoteAdapter;

public interface OnNoteItemClickListener {
    public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position);
}
