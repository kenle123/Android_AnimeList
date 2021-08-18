package com.example.animelist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animelist.R;
import com.example.animelist.SignInScreen;
import com.example.animelist.SignUpScreen;
import com.example.animelist.pojos.Anime;
import com.example.animelist.recyclerview.AnimeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimeListFragment extends Fragment {
    public static List<Anime> animeList = new ArrayList<>();
    private final AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter(generateAnimeList());

    public AnimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anime_list, container, false);

        // RecyclerView setup
        RecyclerView recyclerView = view.findViewById(R.id.anime_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Generates the contents in the anime list
     * @return An arraylist of type anime
     */
    private List<Anime> generateAnimeList() {
        animeList.add(new Anime("Fullmetal Alchemist", "| 9.17", "64"));
        animeList.add(new Anime("Jujutsu Kaisen", "|  8.77", "24"));
        animeList.add(new Anime("Your Lie in April", "| 8.70", "24"));
        animeList.add(new Anime("Steins;Gate", "|  9.10", "24"));
        animeList.add(new Anime("Gintama", "|  8.95", "201"));
        animeList.add(new Anime("Mob Psycho 100", "|  8.48", "12"));
        animeList.add(new Anime("Monster", "|  8.79", "74"));
        animeList.add(new Anime("Cowboy Bebop", "|  8.77", "24"));
        animeList.add(new Anime("One Punch Man", "|  8.53", "12"));
        animeList.add(new Anime("Your Name", "| Rating: 8.91", "1"));
        animeList.add(new Anime("Hunter x Hunter", "|  9.10", "149"));
        animeList.add(new Anime("No Game No Life", "|  8.15", "12"));
        animeList.add(new Anime("Toradora", "|  8.17", "24"));
        animeList.add(new Anime("Angel Beats", "|  8.11", "12"));
        animeList.add(new Anime("Re:Zero", "|  8.17", "24"));
        animeList.add(new Anime("Demon Slayer", "|  8.58", "24"));
        animeList.add(new Anime("A Silent Voice", "|  8.97", "1"));
        animeList.add(new Anime("Erased", "|  8.34", "12"));
        animeList.add(new Anime("Death Parade", "|  8.18", "12"));
        animeList.add(new Anime("Soul Eater", "|  7.86", "51"));
        return animeList;
    }
}