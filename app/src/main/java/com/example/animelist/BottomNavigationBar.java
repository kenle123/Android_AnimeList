package com.example.animelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BottomNavigationBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;
    private AnimeListFragment animeListFragment;
    private UserAnimeListFragment userAnimeListFragment;

    // Creates and displays Nav bar once app runs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        // Bind variables
        mainNav = findViewById(R.id.main_nav);
        mainFrame = findViewById(R.id.main_frame);

        animeListFragment = new AnimeListFragment();
        userAnimeListFragment = new UserAnimeListFragment();

        setFragment(animeListFragment);

    }

    /**
     * Set the fragment to whatever fragment is passed in
     * @param fragment The fragment to display
     */
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()) {
//            case
//        }
        return false;
    }
}