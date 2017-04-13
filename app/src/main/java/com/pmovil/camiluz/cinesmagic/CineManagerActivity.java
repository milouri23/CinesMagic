package com.pmovil.camiluz.cinesmagic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CineManagerActivity extends AppCompatActivity {

    public final static String EXTRA_PELICULA = "com.pmovil.camiluz.cinesmagic.PELICULA";

    static ArrayList<Pelicula> mCartelera;
    String prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_manager);

        String sinopsis = getString(R.string.sinopsis_titulo_1);

        mCartelera = new ArrayList<Pelicula>();
        mCartelera.add(new Pelicula(getString(R.string.titulo_1), R.drawable.cartel_ghost, true,
                false, 3.5f, getString(R.string.sinopsis_titulo_1), getString(R.string.url_titulo_1),
                90, new String[]{"15:30", "18:05", "21:00"}));
        mCartelera.add(new Pelicula(getString(R.string.titulo_2), R.drawable.cartel_logan, true,
                false, 3, getString(R.string.sinopsis_titulo_2), getString(R.string.url_titulo_2),
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
                Pelicula pelicula_escogida = mCartelera.get(position);
                intent.putExtra(EXTRA_PELICULA, pelicula_escogida);
                startActivity(intent);
            }
        });
    }
}
