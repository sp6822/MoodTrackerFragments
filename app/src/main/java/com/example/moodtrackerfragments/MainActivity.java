package com.example.moodtrackerfragments;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        EditText etName = findViewById(R.id.etUserName);

        // הגדרת מאזין ללחיצות בתפריט
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            // בדיקה איזה כפתור נלחץ ושינוי צבע תפריט (בונוס 3)
            if (id == R.id.nav_happy) {
                selectedFragment = new HappyFragment();
                bottomNav.setBackgroundColor(Color.parseColor("#FFCDD2")); // אדום
            } else if (id == R.id.nav_neutral) {
                selectedFragment = new NeutralFragment();
                bottomNav.setBackgroundColor(Color.parseColor("#FFF9C4")); // צהוב
            } else if (id == R.id.nav_sad) {
                selectedFragment = new SadFragment();
                bottomNav.setBackgroundColor(Color.parseColor("#B3E5FC")); // תכלת
            }

            // החלפת הפרגמנט בפועל
            if (selectedFragment != null) {
                // בונוס 2: העברת השם מה-EditText לפרגמנט בעזרת Bundle
                String name = etName.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("userName", name);
                selectedFragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        // בונוס 1: הוספת אנימציה לפני ה-replace
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });

        // הצגת פרגמנט ברירת מחדל בכניסה לאפליקציה
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HappyFragment())
                    .commit();
        }
    }
}