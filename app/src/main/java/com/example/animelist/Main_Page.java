package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.animelist.pojos.Anime;

import java.util.ArrayList;
import java.util.List;

public class Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        AnimeRecyclerAdapter adapter = new AnimeRecyclerAdapter(generateAnimeList());
        RecyclerView recyclerView = findViewById(R.id.anime_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Anime> generateAnimeList() {
        List<Anime> animeList = new ArrayList<>();

        animeList.add(new Anime("Fullmetal Alchemist: Brotherhood", "9.17"));
        animeList.add(new Anime("Jujutsu Kaisen", "8.77"));
        animeList.add(new Anime("Your Lie in April", "8.70"));

        return animeList;
    }
}