package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    public void clickFunction(View view) {

        Log.i("Value", "chris broad in'nt");

        EditText username = (EditText) findViewById(R.id.usernameInput);

        EditText password = (EditText) findViewById(R.id.passwordInput);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}