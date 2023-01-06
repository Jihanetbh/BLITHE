package com.example.blithe;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpAct extends AppCompatActivity {
    private ImageButton back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        back1 = (ImageButton) findViewById(R.id.flecheBack);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback();
            }
        });
    }

    public void goback() {
        Intent intent = new Intent(this, signupsigninact.class);
        startActivity(intent);
    }
}
