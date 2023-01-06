package com.example.blithe;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class SignInAct extends AppCompatActivity {

    private ImageButton back2;
    private ImageButton confirm2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        back2 = (ImageButton) findViewById(R.id.flecheBack2);
        confirm2 = (ImageButton) findViewById(R.id.confirm_button2);

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
}
