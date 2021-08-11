package com.example.animelist.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.service.autofill.CharSequenceTransformation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animelist.R;
import com.example.animelist.pojos.UserInformation;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        // Create instance variable
        UserInformation instance = UserInformation.getInstance();

        TextView name = view.findViewById(R.id.profile_name);
        name.setText(instance.getUsername());

        // Displays username in profile page
        TextView username = view.findViewById(R.id.usernameProfile);
        username.setText(instance.getUsername());

        // Displays email in profile page
        TextView email = view.findViewById(R.id.emailProfile);
        email.setText(instance.getEmail());

        // Displays birthday in profile page
        TextView birthday = view.findViewById(R.id.birthdayProfile);
        birthday.setText("DOB : " + instance.getBirthday());

        // Displays gender in profile page
        TextView gender = view.findViewById(R.id.genderProfile);
        gender.setText(instance.getGender());

        // Displays phone number in profile page
        TextView phoneNumber = view.findViewById(R.id.phoneNumberProfile);
        phoneNumber.setText("Phone: " + instance.getPhoneNumber());

        // Get current date and time and displays it in user profile
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        // Displays current date in user profile page
        TextView displayDate = view.findViewById(R.id.dateProfile);
        displayDate.setText("Acc. Created: "+ strDate);

        return view;
    }
}