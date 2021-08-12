package com.example.animelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.animelist.fragments.AnimeListFragment;
import com.example.animelist.pojos.UserInformation;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText email;
    EditText username;
    EditText password;
    EditText passwordConfirm;
    EditText birthday;
    EditText phoneNumber;
    Spinner mySpinner;

    String[] genders = { "Select Gender", "Male", "Female", "Prefer not to say"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        // Bind variables
        email = findViewById(R.id.id_email);
        username = findViewById(R.id.id_username);
        password = findViewById(R.id.id_password);
        passwordConfirm = findViewById(R.id.id_password_comfirm);
        birthday = findViewById(R.id.id_birthday);
        phoneNumber = findViewById(R.id.id_phone_number);
        mySpinner = findViewById(R.id.spinner);

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
                    UserInformation.getInstance().setEmail(email.getText().toString());
                    UserInformation.getInstance().setUsername(username.getText().toString());
                    UserInformation.getInstance().setPassword(password.getText().toString());
                    UserInformation.getInstance().setBirthday(birthday.getText().toString());
                    UserInformation.getInstance().setPhoneNumber(phoneNumber.getText().toString());
                    UserInformation.getInstance().setGender(mySpinner.getSelectedItem().toString());

                    // Intent to go to sign in page upon successful account creation
                    goToSignInPage(v);
                }
            }
        });

        // TextView button that goes back to sign in screen
        TextView goBackBtn = findViewById(R.id.backToSignIn);
        goBackBtn.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SignInScreen.class);
            v.getContext().startActivity(intent);
        });

        // Adapter for gender drop down
        @SuppressLint("CutPasteId") Spinner spin = findViewById(R.id.spinner);
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
                birthday.getText().length() == 0 || phoneNumber.getText().length() == 0 || mySpinner.getSelectedItem().toString().equals("Select Gender");
    }
    /**
     * Checks if phone number is in correct format
     * @param phone The user inputted phone number
     */
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
    /**
     * Checks if email is in correct format
     * @param email The user inputted email address
     */
    private boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        // To get the selected value from spinner
        Toast.makeText(SignUpScreen.this, "Selected Gender: "+genders[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // something
    }

    /**
     * Go to Sign In Page after account successfully created
     * @param v The view of the fragment
     */
    public void goToSignInPage(View v) {
        Intent intent = new Intent(v.getContext(), SignInScreen.class);
        v.getContext().startActivity(intent);
    }

}