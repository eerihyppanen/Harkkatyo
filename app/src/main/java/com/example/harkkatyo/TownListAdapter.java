package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TownListAdapter extends RecyclerView.Adapter<TownListAdapter.TownViewHolder> {
    private final String[] searchHistory;

    public class TownViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewSearchHistory;

        public TownViewHolder(View view) {
            super(view);
            textViewSearchHistory = view.findViewById(R.id.textViewSearchHistory);
        }
    }

    public TownListAdapter(String[] searchHistory) {
        this.searchHistory = searchHistory;

    }

    @Override
    public TownViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TownViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.town_view, parent, false));
    }



    @Override
    public void onBindViewHolder(TownViewHolder holder, int position) {
        holder.textViewSearchHistory.setText(searchHistory[position]);
    }

    @Override
    public int getItemCount() {
        return searchHistory.length;
    }
}
