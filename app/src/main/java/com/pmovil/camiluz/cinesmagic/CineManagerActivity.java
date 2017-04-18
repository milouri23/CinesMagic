package com.pmovil.camiluz.cinesmagic;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CineManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_manager);


        // Se configura cada página del viewPager de la actividad de acuerdo a los Fragments de
        // Sinopsis, Trailers y Reservas, lo cual se especifica en el adaptador que se le establece
        // a dicho ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        PrincipalAdapter adapter = new PrincipalAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Se configuran pestañas para que actúen de la mano del ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);

        if(getIntent().getStringExtra("Control") != null) {
            Snackbar.make(viewPager, "Su reserva se ha guardado con éxito", Snackbar.LENGTH_SHORT).show();
        }

    }
}