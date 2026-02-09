package com.example.moodtrackerfragments;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_happy) {
                selectedFragment = new HappyFragment();
            } else if (id == R.id.nav_neutral) {
                selectedFragment = new NeutralFragment();
            } else if (id == R.id.nav_sad) {
                selectedFragment = new SadFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        // הוספת הבונוס: אנימציית מעבר חלקה
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HappyFragment())
                    .commit();
        }
    }
}