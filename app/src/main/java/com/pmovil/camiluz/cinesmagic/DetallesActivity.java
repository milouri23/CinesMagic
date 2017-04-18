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

        // Se recibe la película que escogió el usuario
        pelicula = (Pelicula) getIntent().getSerializableExtra(CarteleraFragment.EXTRA_PELICULA);

        // Se configura cada página del viewPager de la actividad de acuerdo a los Fragments de
        // Sinopsis, Trailers y Reservas, lo cual se especifica en el adaptador que se le establece
        // a dicho ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        DetallesAdapter adapter = new DetallesAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Se configuran pestañas para que actúen de la mano del ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}