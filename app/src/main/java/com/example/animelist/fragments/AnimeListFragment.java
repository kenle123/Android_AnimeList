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

    /**
     * Generates the contents in the anime list
     * @return An arraylist of type anime
     */
    private List<Anime> generateAnimeList() {
        List<Anime> animeList = new ArrayList<>();

        animeList.add(new Anime("Fullmetal Alchemist", "| Rating: 9.17"));
        animeList.add(new Anime("Jujutsu Kaisen", "| Rating: 8.77"));
        animeList.add(new Anime("Your Lie in April", "| Rating: 8.70"));
        animeList.add(new Anime("Steins;Gate", "| Rating: 9.10"));
        animeList.add(new Anime("Gintama", "| Rating: 8.95"));
        animeList.add(new Anime("Mob Psycho 100", "| Rating: 8.48"));
        animeList.add(new Anime("Monster", "| Rating: 8.79"));
        animeList.add(new Anime("Cowboy Bebop", "| Rating: 8.77"));
        animeList.add(new Anime("One Punch Man", "| Rating: 8.53"));
        animeList.add(new Anime("Your Name", "| Rating: 8.91"));
        animeList.add(new Anime("Hunter x Hunter", "| Rating: 9.10"));
        animeList.add(new Anime("No Game No Life", "| Rating: 8.15"));
        animeList.add(new Anime("Toradora", "| Rating: 8.17"));
        animeList.add(new Anime("Angel Beats", "| Rating: 8.11"));
        animeList.add(new Anime("Re:Zero", "| Rating: 8.17"));
        animeList.add(new Anime("Demon Slayer", "| Rating: 8.58"));
        animeList.add(new Anime("A Silent Voice", "| Rating: 8.97"));
        animeList.add(new Anime("Erased", "| Rating: 8.34"));
        animeList.add(new Anime("Death Parade", "| Rating: 8.18"));
        animeList.add(new Anime("Soul Eater", "| Rating: 7.86"));

        return animeList;
    }
    public void addAnime(View v) {
        Log.i("Anime", "ANIME");
    }

}