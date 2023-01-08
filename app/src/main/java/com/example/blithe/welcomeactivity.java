package com.example.blithe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcomeactivity extends AppCompatActivity {
    private Button start;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_to_blithe);
        start = (Button) findViewById(R.id.GetStarted);
        mAuth = FirebaseAuth.getInstance();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGetStarted();
            }
        });
    }
    public void openGetStarted() {
        Intent intent = new Intent(this,signupsigninact.class);
        startActivity(intent);
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(this,welcomeactivity.class));
        }
    }*/
    }

