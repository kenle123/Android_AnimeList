package com.example.animelist.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.animelist.R;
import com.example.animelist.SignInScreen;
import com.example.animelist.pojos.UserInformation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Stores number of user animes in variable
        int numberOfUserAnimes = UserAnimeListFragment.userAnimeList.size();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        // Create instance variable
        UserInformation instance = UserInformation.getInstance();

        TextView name = view.findViewById(R.id.profile_name);
        name.setText(instance.getUsername());

        // Displays username in profile page
        TextView username = view.findViewById(R.id.profile_name);
        username.setText(instance.getUsername());

        // Displays email in profile page
        TextView email = view.findViewById(R.id.emailProfile);
        email.setText("  Email Address: " + instance.getEmail());

        // Displays birthday in profile page
        TextView birthday = view.findViewById(R.id.birthdayProfile);
        birthday.setText("  Date of Birth : " + instance.getBirthday());

        // Displays gender in profile page
        TextView gender = view.findViewById(R.id.genderProfile);
        gender.setText("  Gender: " + instance.getGender());

        // Displays phone number in profile page
        TextView phoneNumber = view.findViewById(R.id.phoneNumberProfile);
        phoneNumber.setText("  Phone: " + instance.getPhoneNumber());

        // Get current date and time and displays it in user profile
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate= formatter.format(date);

        // Displays current date in user profile page
        TextView displayDate = view.findViewById(R.id.dateProfile);
        displayDate.setText("  Account Created: " + strDate);

        // Displays gender in profile page
        TextView numberOfAnimes = view.findViewById(R.id.numberOfAnimesProfile);
        numberOfAnimes.setText("  Number of Animes in your list : " + numberOfUserAnimes);

        // Sign out button that goes to sign in screen
        Button goToLoginPage = view.findViewById(R.id.signOutButton);
        goToLoginPage.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SignInScreen.class);
            v.getContext().startActivity(intent);
        });


        return view;
    }
}