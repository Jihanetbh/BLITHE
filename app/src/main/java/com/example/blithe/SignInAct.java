package com.example.blithe;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;
import java.util.Set;

public class SignInAct extends AppCompatActivity {

    private ImageButton back2;
    private ImageButton confirm2;
    private EditText mEmailField;
    private EditText mPasswordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        back2 = (ImageButton) findViewById(R.id.flecheBack2);
        confirm2 = (ImageButton) findViewById(R.id.confirm_button2);

        mEmailField = findViewById(R.id.textView9);
        mPasswordField = findViewById(R.id.textView10);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback2();
            }
        });
        confirm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Confirm();
            }
        });
    }

    public void goback2() {
        Intent intent = new Intent(this, signupsigninact.class);
        startActivity(intent);
    }
    public void Confirm() {
        Intent intent = new Intent(this, HomeAct.class);
        startActivity(intent);
    }
    public void signIn(View view) {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        // Check if the entered email and password match a stored combination
        if (emailExists(email) && passwordMatches(email, password)) {
            // Login credentials are correct, start the main activity
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        } else {
            // Login credentials are incorrect, show an error message
            Toast.makeText(this, "Error: Invalid login credentials", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean emailExists(String email) {
        // Get the stored emails from shared preferences
        Set<String> emails = getSharedPreferences("users", MODE_PRIVATE).getStringSet("emails", null);
        if (emails == null) {
            return false;
        }
        // Check if the entered email is in the stored emails set
        return emails.contains(email);
    }

    private boolean passwordMatches(String email, String password) {
        // Get the stored passwords from shared preferences
        Map<String, String> passwords = (Map<String, String>) getSharedPreferences("users", MODE_PRIVATE).getAll().get("passwords");
        if (passwords == null) {
            return false;
        }
        // Check if the entered password matches the stored password for the given email
        return password.equals(passwords.get(email));
    }
}

