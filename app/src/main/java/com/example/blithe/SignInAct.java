package com.example.blithe;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Map;
import java.util.Set;

public class SignInAct extends AppCompatActivity {

    private ImageButton back2;
    private ImageButton confirm2;
    private EditText mEmailField;
    private EditText mPasswordField;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        back2 = (ImageButton) findViewById(R.id.flecheBack2);
        confirm2 = (ImageButton) findViewById(R.id.confirm_button2);

        mEmailField = findViewById(R.id.textView9);
        mPasswordField = findViewById(R.id.textView10);

        mAuth = FirebaseAuth.getInstance();
        confirm2.setOnClickListener(view -> {
            loginUser();
        });
        back2.setOnClickListener(view -> {
            startActivity(new Intent(SignInAct.this, signupsigninact.class));

        });

    }

    private void loginUser() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Email cannot be empty");
            mEmailField.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Password cannot be empty");
            mPasswordField.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email.trim(),password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignInAct.this, "User signed in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInAct.this, HomeAct.class));
                        finish();
                    } else {
                        Toast.makeText(SignInAct.this, "Sign in Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }
}

