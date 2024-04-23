package com.example.harkkatyo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentA extends Fragment {


    public FragmentA() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_a, container, false);

        /*txtWeatherTest = view.findViewById(R.id.txtWeatherTest);
        txtPopulationTest = view.findViewById(R.id.txtTownTest);

        Bundle args = getArguments();
        if (args != null) {
            String weather = args.getString("weather");
            String population = args.getString("population");

            txtWeatherTest.setText(weather);
            txtPopulationTest.setText(population);
        }*/


        return view;
    }
}