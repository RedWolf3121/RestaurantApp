package com.example.dani.restaurantapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RegistroFragment extends Fragment {

    public static RegistroFragment newInstance() {
        return new RegistroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro , container, false);

    }

}