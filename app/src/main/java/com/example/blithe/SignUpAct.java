package com.example.blithe;
import android.content.Intent;
import android.content.SharedPreferences;
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



public class SignUpAct extends AppCompatActivity {
    private ImageButton back1;
    private ImageButton confirm1;
    private EditText mEmailField;
    private EditText mPasswordField;
    private EditText mPasswordConfirmationField;
    private EditText mUsernameField;
    private EditText mFullName;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        back1 = (ImageButton) findViewById(R.id.flecheBack);
        confirm1 = (ImageButton) findViewById(R.id.confirm_button);
        mEmailField = findViewById(R.id.textView6);
        mPasswordField = findViewById(R.id.textView7);
        mPasswordConfirmationField = findViewById(R.id.textView8);
        mUsernameField = findViewById(R.id.textView4);
        mFullName = findViewById(R.id.textView5);

        mAuth = FirebaseAuth.getInstance();
        confirm1.setOnClickListener(view -> {
            createUser();
        });

        back1.setOnClickListener(view -> {
            startActivity(new Intent(SignUpAct.this, signupsigninact.class));

        });
    }

    private void createUser() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();
        String passcon = mPasswordConfirmationField.getText().toString();
        String username = mUsernameField.getText().toString();
        String fullname = mFullName.getText().toString();


        if (TextUtils.isEmpty(username)) {
            mUsernameField.setError("username cannot be empty");
            mUsernameField.requestFocus();
        }else if (TextUtils.isEmpty(fullname)) {
            mFullName.setError("fullname cannot be empty");
            mFullName.requestFocus();}
        else if (TextUtils.isEmpty(email)) {
             mEmailField.setError("Email cannot be empty");
             mEmailField.requestFocus();}
        else if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Password cannot be empty");
            mPasswordField.requestFocus();
        }
        else if (!passcon.equals(password)) {
            mPasswordConfirmationField.setError("Password and its confirmation are not compatible");
            mPasswordConfirmationField.requestFocus(); }
        else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpAct.this, "User signed in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpAct.this, SignInAct.class));
                        finish();
                    }
                    else{
                        Toast.makeText(SignUpAct.this, "Registration Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
            {


            }


        }

    }
    }

