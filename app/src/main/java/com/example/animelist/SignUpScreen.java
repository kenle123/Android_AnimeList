package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.logging.Logger;

public class SignUpScreen extends AppCompatActivity {
    EditText email;
    EditText username;
    EditText password;
    EditText passwordConfirm;
    EditText birthday;
    EditText gender;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        // bind variables
        email = (EditText) findViewById(R.id.id_email);
        username = (EditText) findViewById(R.id.id_username);
        password = (EditText) findViewById(R.id.id_password);
        passwordConfirm = (EditText) findViewById(R.id.id_password_comfirm);
        birthday = (EditText) findViewById(R.id.id_birthday);
        gender = (EditText) findViewById(R.id.id_gender);
        phoneNumber = (EditText) findViewById(R.id.id_phone_number);

        // Checks if there are any missing fields when user creates account
        Button createAccountBtn = (Button) findViewById(R.id.create_account_btn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFieldEmpty = checkIfFieldEmpty();
                if(isFieldEmpty) {
                    Toast.makeText(SignUpScreen.this, "Field(s) cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                // Checks if password and confirm password is the same
                else if(!(password.getText().toString().equals(passwordConfirm.getText().toString()))) {
                    Toast.makeText(SignUpScreen.this, "Confirm password not identical", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
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

    /**
     * Checks if an EditText field is empty
     * @return True if any of the EditText fields are empty, false otherwise
     */
    public boolean checkIfFieldEmpty() {
        return email.getText().length() == 0 || username.getText().length() == 0 ||
                password.getText().length() == 0 || passwordConfirm.getText().length() == 0 ||
                birthday.getText().length() == 0 || gender.getText().length() == 0 ||
                phoneNumber.getText().length() == 0;
    }
}