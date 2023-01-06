package com.example.blithe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class signupsigninact extends AppCompatActivity {
    private ImageButton subutton;
    private ImageButton sibutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_signin_blithe);
        subutton =(ImageButton) findViewById(R.id.SignUp);
        sibutton =(ImageButton) findViewById(R.id.SignIn);
        subutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });
        sibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignIn();
            }
        });
    }
    public void openSignUp() {
        Intent intent = new Intent(this,SignUpAct.class);
        startActivity(intent);
    }
    public void openSignIn() {
        Intent intent = new Intent(this,SignInAct.class);
        startActivity(intent);
    }

}
