package com.example.animelist.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.fragments.AnimeListFragment;
import com.example.animelist.fragments.UserAnimeListFragment;
import com.example.animelist.pojos.Anime;

import java.util.ArrayList;
import java.util.List;

// Connects RecyclerView to ArrayList of anime objects
public class AnimeRecyclerAdapter extends RecyclerView.Adapter {
    List<Anime> models = new ArrayList<>();

    public AnimeRecyclerAdapter(List<Anime> viewModels) {
        if(viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new AnimeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        ((AnimeRecyclerViewHolder) holder).bindData(models.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                builder1.setMessage("Do you want to add this anime to your list?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Store clicked anime list item in Anime object
                                Anime clickedAnime = new Anime(AnimeListFragment.animeList.get(position).getAnimeName(),
                                        AnimeListFragment.animeList.get(position).getAnimeRating(),
                                        AnimeListFragment.animeList.get(position).getAnimeEpisodeCount());

                                // Add clicked anime to user anime list so it will appear in user anime list fragment
                                UserAnimeListFragment.userAnimeList.add(new Anime(clickedAnime.getAnimeName(),
                                        clickedAnime.getAnimeRating(),
                                        clickedAnime.getAnimeEpisodeCount()));
                                Toast.makeText(v.getContext(), clickedAnime.getAnimeName() + " successfully added to user's anime list!", Toast.LENGTH_SHORT).show();

                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

//                // Store clicked anime list item in Anime object
//                Anime clickedAnime = new Anime(AnimeListFragment.animeList.get(position).getAnimeName(),
//                        AnimeListFragment.animeList.get(position).getAnimeRating(),
//                        AnimeListFragment.animeList.get(position).getAnimeEpisodeCount());
//
//                // Add clicked anime to user anime list so it will appear in user anime list fragment
//                UserAnimeListFragment.userAnimeList.add(new Anime(clickedAnime.getAnimeName(),
//                                                                  clickedAnime.getAnimeRating(),
//                                                                  clickedAnime.getAnimeEpisodeCount()));
                //Toast.makeText(v.getContext(), clickedAnime.getAnimeName() + " successfully added to user's anime list!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Gets size of list
     * @return Size of list
     */
    @Override
    public int getItemCount() {
        return models.size();
    }

    /**
     * Gets type of item
     * @return Type of item
     */
    @Override
    public int getItemViewType(final int position) {
        return R.layout.anime_list_item;
    }
}
