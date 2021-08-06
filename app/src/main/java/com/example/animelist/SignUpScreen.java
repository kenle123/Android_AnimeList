package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText email;
    EditText username;
    EditText password;
    EditText passwordConfirm;
    EditText birthday;
    EditText gender;
    EditText phoneNumber;

    String[] genders = { "Select Gender", "Male", "Female", "Prefer not to say"};

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
                else if(!isValidPhone(phoneNumber.getText().toString())) {
                    Toast.makeText(SignUpScreen.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if(!isValidMail(email.getText().toString())) {
                    Toast.makeText(SignUpScreen.this, "Invalid Email", Toast.LENGTH_SHORT).show();
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
        // Adapter for gender drop down
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

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
    // Checks if phone number that user entered is correct format
    public static boolean isValidPhone(String phone) {

        String expression = "^([0-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{3,15}$";
        CharSequence inputString = phone;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches())
        {
            return true;
        }
        else{
            return false;
        }
    }
    // Checks if email is in the correct format
    private boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        // To get the selected value from spinner
            //  Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
            //  String text = mySpinner.getSelectedItem().toString();
        Toast.makeText(SignUpScreen.this, "Selected User: "+genders[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // something
    }

//    @Override
//    public void onClick(View v) {
//    }
}