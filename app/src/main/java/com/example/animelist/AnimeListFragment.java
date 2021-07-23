package com.example.animelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animelist.pojos.Anime;

import java.util.ArrayList;
import java.util.List;

public class AnimeListFragment extends Fragment {

    public AnimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);

        AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter(generateAnimeList());
        RecyclerView recyclerView = view.findViewById(R.id.anime_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    private List<Anime> generateAnimeList() {
        List<Anime> animeList = new ArrayList<>();

        animeList.add(new Anime("Fullmetal Alchemist", "| Rating: 9.17"));
        animeList.add(new Anime("Jujutsu Kaisen", "| Rating: 8.77"));
        animeList.add(new Anime("Your Lie in April", "| Rating: 8.70"));

        return animeList;
    }
}