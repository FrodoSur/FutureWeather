package com.example.futureweather;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class citieschoose extends Fragment {

    private static final String TAG = "citiesChooseFragment";
    public citieschoose() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cities, container, false);
    }
    public void OnViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        initCities(view);
    }
    @SuppressLint("SetTextI18n")
    private void initCities(View view){
        LinearLayout layoutView = (LinearLayout)view;
        TextView city = new TextView(getContext());
        city.setText("Moscow");
        city.setTextSize(20);
        layoutView.addView(city);
        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.getIntent(getContext(), "id", 1));
            }
        });
    }
}