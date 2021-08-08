package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Bind variables for username and password
        EditText username = (EditText) findViewById(R.id.usernameInput);
        EditText password = (EditText) findViewById(R.id.passwordInput);

        // Login button, for now only goes to sign up activity
        Button loginBtn = (Button) findViewById(R.id.button);

        // Button that goes to sign up page
        Button goToLoginPage = (Button) findViewById(R.id.goToSignUp);
        goToLoginPage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), SignUpScreen.class);
                    v.getContext().startActivity(intent);
                }
        });

        // Login button that goes to the navigation bar
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BottomNavigationBar.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}