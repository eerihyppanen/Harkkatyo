package com.example.harkkatyo;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class TownViewHolder extends RecyclerView.ViewHolder {

    TextView textViewSearchHistory;
    EditText editTextTown;

    public TownViewHolder(@NonNull View itemView) {
        super(itemView);
        editTextTown = itemView.findViewById(R.id.editTextTown);



    }
}
