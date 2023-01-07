package com.example.blithe;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SignUpAct extends AppCompatActivity {
    private ImageButton back1;
    private ImageButton confirm1;
    private EditText mEmailField;
    private EditText mPasswordField;
    private EditText mPasswordConfirmationField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        back1 = (ImageButton) findViewById(R.id.flecheBack);
        confirm1 = (ImageButton) findViewById(R.id.confirm_button);
        mEmailField = findViewById(R.id.textView6);
        mPasswordField = findViewById(R.id.textView7);
        mPasswordConfirmationField = findViewById(R.id.textView8);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
        confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirm1();
            }
        });
    }


    public void goback() {
        Intent intent = new Intent(this, signupsigninact.class);
        startActivity(intent);
    }
    public void Confirm1() {
        Intent intent = new Intent(this, HomeAct.class);
        startActivity(intent);
    }
    public void signUp(View view) {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();
        String passwordConfirmation = mPasswordConfirmationField.getText().toString();

        // Validate the entered data
        if (isValidEmail(email) && isValidPassword(password) && password.equals(passwordConfirmation)) {
            // Data is valid, add the email and password combination to shared preferences
            SharedPreferences preferences = getSharedPreferences("users", MODE_PRIVATE);
            Set<String> emails = preferences.getStringSet("emails", new HashSet<String>());
            emails.add(email);
            preferences.edit().putStringSet("emails", emails).apply();

            Map<String, String> passwords = (Map<String, String>) preferences.getAll().get("passwords");
            if (passwords == null) {
                passwords = new HashMap<>();
            }
            passwords.put(email, password);
            preferences.edit().putString("passwords", String.valueOf(passwords)).apply();

            // Show a success message
            Toast.makeText(this, "Success: Account created", Toast.LENGTH_SHORT).show();

            // Go back to the login activity
            Intent loginIntent = new Intent(this, SignInAct.class);
            startActivity(loginIntent);
        } else {
            // Data is invalid, show an error message
            Toast.makeText(this, "Error: Invalid sign up information", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidEmail(String email) {
        // Add email validation code here
        return true;
    }

    private boolean isValidPassword(String password) {
        // Add password validation code here
        return true;
    }
}
