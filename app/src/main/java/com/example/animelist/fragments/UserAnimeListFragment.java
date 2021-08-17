package com.example.animelist.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animelist.R;
import com.example.animelist.pojos.Anime;
import com.example.animelist.recyclerview.AnimeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserAnimeListFragment extends Fragment {
    public static List<Anime> userAnimeList = new ArrayList<>();

    public UserAnimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_anime_list, container, false);

        // RecyclerView setup
        AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.user_anime_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    /**
     * Generates the contents in the anime list
     * @return An arraylist of type anime
     */
//    private List<Anime> generateAnimeList() {
//        userAnimeList.add(new Anime("Jujutsu Kaisen", "|  8.77", "24"));
//        return userAnimeList;
//    }
}