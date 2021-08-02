package com.example.animelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserProfileFragment extends Fragment {


    public UserProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        View view1 = inflater.inflate(R.layout.fragment_user_profile, container, false);

        TextView username = view.findViewById(R.id.usernameProfile);
        username.setText("Bob Jones");

        return view;

    }
}