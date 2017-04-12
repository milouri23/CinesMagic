package com.pmovil.camiluz.cinesmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CineManagerActivity extends AppCompatActivity {

    static ArrayList<Pelicula> mCartelera;
    String prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_manager);

        String sinopsis = getString(R.string.sinopsis_ghost_in_the_shell);

        mCartelera = new ArrayList<Pelicula>();
        mCartelera.add(new Pelicula("Ghost in the Shell", R.drawable.cartel_ghost, true, false, 3.5f,
                getString(R.string.sinopsis_ghost_in_the_shell),
                "https://www.youtube.com/watch?v=kOdhsIFPzJk", 90,
                new String[]{"15:30", "18:05", "21:00"}));
        mCartelera.add(new Pelicula("Logan", R.drawable.cartel_logan, true, false, 3,
                getString(R.string.sinopsis_logan), "https://www.youtube.com/watch?v=kOdhsIFPzJk",
                85, new String[]{"14:20", "17:55", "20:32"}));
        mCartelera.add(new Pelicula("Power Rangers", R.drawable.cartel_power, true, true));
        mCartelera.add(new Pelicula("Life", R.drawable.cartel_life, false, true));

        Pelicula ghost = new Pelicula("Ghost in the Shell", R.drawable.cartel_ghost, true, false);
        PeliculaAdapter adaptadorDePeliculas = new PeliculaAdapter(this, mCartelera);

        GridView diseñoCuadricula = (GridView) findViewById(R.id.diseño_cuadricula);
        diseñoCuadricula.setAdapter(adaptadorDePeliculas);

        diseñoCuadricula.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(CineManagerActivity.this, DetallesActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

}
