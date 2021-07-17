package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.animelist.pojos.Anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.anime_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<Anime> generateSimpleList() {
        List<Anime> simpleViewModelList = new ArrayList<>();

        simpleViewModelList.add(new Anime("Death Note"));
        simpleViewModelList.add(new Anime("asDFSFAFAFASFASFASF"));
        simpleViewModelList.add(new Anime("ioasjflkasmflksiocj lkmslkfasj"));

        return simpleViewModelList;
    }
}