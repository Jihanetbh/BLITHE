package com.example.blithe;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeAct extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private ImageButton mMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mMenuButton = findViewById(R.id.imageButton);
        NavigationView navigationView = findViewById(R.id.naview);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        // Set up the click listener for the image button
        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Toast.makeText(HomeAct.this, "hihi you touched noot's profile", Toast.LENGTH_SHORT).show();
                        // Open the sign in activity
                        Intent OpenProfileIntent = new Intent(HomeAct.this, ProfileAct.class);
                        startActivity(OpenProfileIntent);
                        return true;
                    case R.id.wishlist:
                        // Open the sign in activity
                        Intent OpenWishList = new Intent(HomeAct.this, WishListAct.class);
                        startActivity(OpenWishList);
                        return true;
                    case R.id.logout:
                        // Open the sign in activity
                        Intent SignOutIntent = new Intent(HomeAct.this, SignInAct.class);
                        Log.d("HomeAct", "Starting sign in activity with intent: " + SignOutIntent);
                        startActivity(SignOutIntent);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidebarmenu, menu);
        return true;
    }
}


