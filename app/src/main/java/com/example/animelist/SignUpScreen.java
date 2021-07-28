package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        // bind variables
        EditText email = (EditText) findViewById(R.id.id_email);
        EditText username = (EditText) findViewById(R.id.id_username);
        EditText password = (EditText) findViewById(R.id.id_password);
        EditText passwordConfirm = (EditText) findViewById(R.id.id_password_comfirm);
        EditText birthday = (EditText) findViewById(R.id.id_birthday);
        EditText gender = (EditText) findViewById(R.id.id_gender);
        EditText phone_number = (EditText) findViewById(R.id.id_phone_number);

        // Checks if there are any missing fields when user creates account
        Button createAccountBtn = (Button) findViewById(R.id.create_account_btn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (username.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (passwordConfirm.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (birthday.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (gender.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else if (phone_number.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpScreen.this, "Missing field(s)", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(v.getContext(), BottomNavigationBar.class);
                    v.getContext().startActivity(intent);
                }
            }
        });

        TextView goBackBtn = (TextView) findViewById(R.id.backToSignIn);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}