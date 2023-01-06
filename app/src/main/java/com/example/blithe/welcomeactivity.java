package com.example.blithe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class welcomeactivity extends AppCompatActivity {
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_to_blithe);
        start =(Button) findViewById(R.id.GetStarted);

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


}
