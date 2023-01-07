package com.example.blithe;
import androidx.appcompat.app.ActionBar;
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
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidebarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the toggle button click here
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle the menu item clicks here
        switch (item.getItemId()) {
            case R.id.logout:
                // Open the sign in activity
                Intent SignOutIntent = new Intent(this, SignInAct.class);
                Log.d("HomeAct", "Starting sign in activity with intent: " + SignOutIntent);
                startActivity(SignOutIntent);
                return true;
            case R.id.profile:
                // Open the sign in activity
                Intent OpenProfileIntent = new Intent(this, ProfileAct.class);
                startActivity(OpenProfileIntent);
                return true;
            case R.id.wishlist:
                // Open the sign in activity
                Intent OpenWishList = new Intent(this, WishListAct.class);
                startActivity(OpenWishList);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
