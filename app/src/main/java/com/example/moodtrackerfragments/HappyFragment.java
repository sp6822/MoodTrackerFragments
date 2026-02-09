package com.example.moodtrackerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class HappyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // השורה הזו מחברת בין קובץ ה-Java לקובץ ה-XML של הפרגמנט
        return inflater.inflate(R.layout.fragment_happy, container, false);
    }
}