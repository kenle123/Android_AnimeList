package com.example.animelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.animelist.fragments.AnimeListFragment;
import com.example.animelist.fragments.UserAnimeListFragment;
import com.example.animelist.fragments.UserProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationBar extends AppCompatActivity {
    private BottomNavigationView mainNav;
    private AnimeListFragment animeListFragment;
    private UserAnimeListFragment userAnimeListFragment;
    private UserProfileFragment userProfileFragment;

    // Creates and displays Nav bar once app runs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        // Bind variables
        mainNav = findViewById(R.id.main_nav);

        // Initialize fragments
        animeListFragment = new AnimeListFragment();
        userAnimeListFragment = new UserAnimeListFragment();
        userProfileFragment = new UserProfileFragment();

        // Sets first fragment as anime list fragment
        setFragment(animeListFragment);

        // Click listener for bottom navigation bar menu items
        mainNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.main_anime_list:
                        setFragment(animeListFragment);
                        return true;
                    case R.id.user_anime_list:
                        setFragment(userAnimeListFragment);
                        return true;
                    case R.id.user_profile:
                        setFragment(userProfileFragment);
                }
                return true;
            }
        });
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
}