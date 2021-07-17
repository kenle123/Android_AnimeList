package com.example.animelist;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.pojos.Anime;

public class AnimeRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView animeTextView;

    public AnimeRecyclerViewHolder(final View itemView) {
        super(itemView);
        animeTextView = (TextView) itemView.findViewById(R.id.list_item);
    }

    public void bindData(final Anime viewModel) {
        animeTextView.setText(viewModel.getAnimeName());
    }
}
