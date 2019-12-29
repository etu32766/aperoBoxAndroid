package com.example.aperobox.Activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.aperobox.R;
import com.example.aperobox.Application.AperoBoxApplication;
import com.google.android.material.button.MaterialButton;

public class AProposFragment extends Fragment {

    private SharedPreferences preferences;
    private ViewGroup container;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.apropos_fragment, container, false);
        this.container = container;

        MaterialButton menu = ((MainActivity)getActivity()).apropos;
        menu.setOnClickListener(null);
        menu.setElevation(1);

        // Set cut corner background for API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.findViewById(R.id.apropos_grid)
                    .setBackgroundResource(R.drawable.product_grid_background_shape);
        }
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AperoBoxApplication.getInstance().isNightModeEnabled()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();

        MaterialButton accueil = ((MainActivity)getActivity()).acceuil;
        accueil.setElevation(0);
        MaterialButton apropos = ((MainActivity)getActivity()).apropos;
        apropos.setOnClickListener(null);
        apropos.setElevation(1);
        MaterialButton compte = ((MainActivity)getActivity()).compte;
        compte.setElevation(0);
        MaterialButton option = ((MainActivity)getActivity()).option;
        option.setElevation(0);
        MaterialButton panierM = ((MainActivity)getActivity()).panier;
        panierM.setElevation(0);
        MaterialButton boxPerso = ((MainActivity)getActivity()).boxPersonnalise;
        boxPerso.setElevation(0);

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}