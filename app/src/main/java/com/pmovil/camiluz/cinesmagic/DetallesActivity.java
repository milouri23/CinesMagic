package com.pmovil.camiluz.cinesmagic;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class DetallesActivity extends AppCompatActivity {

    public static Pelicula pelicula;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        pelicula = (Pelicula) getIntent().getSerializableExtra(
                CineManagerActivity.EXTRA_PELICULA);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        DetallesAdapter adapter = new DetallesAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

}


