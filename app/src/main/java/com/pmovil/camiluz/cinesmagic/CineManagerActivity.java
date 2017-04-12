package com.pmovil.camiluz.cinesmagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class CineManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_manager);

        ArrayList<Pelicula> cartelera = new ArrayList<Pelicula>();
        cartelera.add(new Pelicula("Ghost in the Shell", R.drawable.cartel_ghost, true, false));
        cartelera.add(new Pelicula("Logan", R.drawable.cartel_logan, true, false));

        Pelicula ghost = new Pelicula("Ghost in the Shell", R.drawable.cartel_ghost, true, false);
        PeliculaAdapter adaptadorDePeliculas = new PeliculaAdapter(this, cartelera);

        GridView diseñoCuadricula = (GridView) findViewById(R.id.diseño_cuadricula);
        diseñoCuadricula.setAdapter(adaptadorDePeliculas);
    }

}
