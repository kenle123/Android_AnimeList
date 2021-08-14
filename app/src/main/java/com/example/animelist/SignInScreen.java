package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.animelist.pojos.UserInformation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SignInScreen extends AppCompatActivity {
    // Instance variables
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind variables
        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.passwordInput);

        // Create account button that goes to sign up page with on-click listener
        Button goToLoginPage = findViewById(R.id.goToSignUp);
        goToLoginPage.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SignUpScreen.class);
            v.getContext().startActivity(intent);
        });

        // Login button that goes to main anime list page with on-click listener
        Button loginBtn = findViewById(R.id.button);
        loginBtn.setOnClickListener(v -> {
//            UserInformation instance = UserInformation.getInstance();
//            if(username.getText().toString().equals(instance.getUsername()) &&
//               password.getText().toString().equals(instance.getPassword())) {
//                goToMainPage(v);
//            }
//            else {
//                Toast.makeText(SignInScreen.this, "Username or password not valid!", Toast.LENGTH_SHORT).show();
//            }
            Intent intent = new Intent(v.getContext(), BottomNavigationBar.class);
            v.getContext().startActivity(intent);
        });
    }

    /**
     * Called when user successfully logins. Goes to main anime list page
     * @param v The current view
     */
    public void goToMainPage(View v) {
        Intent intent = new Intent(v.getContext(), BottomNavigationBar.class);
        v.getContext().startActivity(intent);
    }
}