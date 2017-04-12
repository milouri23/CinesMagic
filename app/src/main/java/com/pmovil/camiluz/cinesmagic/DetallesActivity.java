package com.pmovil.camiluz.cinesmagic;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;

import java.util.ArrayList;

public class DetallesActivity extends AppCompatActivity {

    Pelicula mPeliculaActual;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);

        if(position != -1) {
            mPeliculaActual = CineManagerActivity.mCartelera.get(position);
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        DetallesAdapter adapter = new DetallesAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

}


