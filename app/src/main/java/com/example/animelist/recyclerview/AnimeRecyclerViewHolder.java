package com.example.animelist.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.pojos.Anime;

public class AnimeRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView animeNameTextView;
    private TextView animeRatingTextView;

    /**
     * Connects the anime name and rating to recycler view
     * @param itemView The list item
     */
    public AnimeRecyclerViewHolder(final View itemView) {
        super(itemView);
        animeNameTextView = itemView.findViewById(R.id.anime_list_name);
        animeRatingTextView = itemView.findViewById(R.id.anime_list_rating);
    }
    // Sets text views to user specified name and rating
    /**
     * Connects data to item in list
     * @param viewModel The recycler view
     */
    public void bindData(final Anime viewModel) {
        animeNameTextView.setText(viewModel.getAnimeName());
        animeRatingTextView.setText(viewModel.getAnimeRating());
    }
}
