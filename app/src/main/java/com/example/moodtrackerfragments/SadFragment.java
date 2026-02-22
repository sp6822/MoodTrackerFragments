package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class SadFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // חיבור ל-XML של הפרגמנט העצוב
        View view = inflater.inflate(R.layout.fragment_sad, container, false);

        // בונוס 2: קבלת השם והצגתו
        if (getArguments() != null) {
            String name = getArguments().getString("userName");
            TextView tvWelcome = view.findViewById(R.id.tv);
            if (name != null && !name.isEmpty()) {
                tvWelcome.setText("שלום " + name + "\nאני מרגיש עצוב היום");
            }
        }

        return view;
    }
}