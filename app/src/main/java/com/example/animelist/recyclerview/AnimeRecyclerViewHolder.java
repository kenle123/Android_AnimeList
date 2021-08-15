package com.example.animelist.recyclerview;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.pojos.Anime;

public class AnimeRecyclerViewHolder extends RecyclerView.ViewHolder {
    private final TextView animeNameTextView;
    private final TextView animeRatingTextView;
    private final TextView animeEpisodeCount;

    /**
     * Connects the anime information to recycler view
     * @param itemView The list item
     */
    public AnimeRecyclerViewHolder(final View itemView) {
        super(itemView);
        animeNameTextView = itemView.findViewById(R.id.anime_list_name);
        animeRatingTextView = itemView.findViewById(R.id.anime_list_rating);
        animeEpisodeCount = itemView.findViewById(R.id.anime_episode_count);
    }

    /**
     * Connects data to item in list
     * @param viewModel The recycler view
     */
    @SuppressLint("SetTextI18n")
    public void bindData(final Anime viewModel) {
        animeNameTextView.setText(viewModel.getAnimeName());
        animeRatingTextView.setText("Rating: " + viewModel.getAnimeRating());
        animeEpisodeCount.setText("Episodes: " + viewModel.getAnimeEpisodeCount());
    }
}
