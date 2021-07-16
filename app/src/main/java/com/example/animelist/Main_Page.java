package com.example.animelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.animelist.pojos.SimpleAdapter;
import com.example.animelist.pojos.SimpleViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleAdapter adapter = new SimpleAdapter(generateSimpleList());
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.simple_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private List<SimpleViewModel> generateSimpleList() {
        List<SimpleViewModel> simpleViewModelList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            simpleViewModelList.add(new SimpleViewModel(String.format(Locale.US, "This is item %d", i)));
        }

        return simpleViewModelList;
    }
}