package com.example.animelist.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.pojos.Anime;

import java.util.ArrayList;
import java.util.List;

// connects RecyclerView to ArrayList of anime objects
public class AnimeRecyclerAdapter extends RecyclerView.Adapter {
    List<Anime> models = new ArrayList<>();

    public AnimeRecyclerAdapter(List<Anime> viewModels) {
        if(viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new AnimeRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((AnimeRecyclerViewHolder) holder).bindData(models.get(position));
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
