package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.gameplay:
                        Toast.makeText(MainActivity.this, "Gameplay Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.archive:
                        Toast.makeText(MainActivity.this, "Archive Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.history:
                        Toast.makeText(MainActivity.this, "Match History Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Profile Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.faqs:
                        Toast.makeText(MainActivity.this, "FAQs Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.feedback:
                        Toast.makeText(MainActivity.this, "Feedback Selected", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "Logout Selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer after item selection
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}