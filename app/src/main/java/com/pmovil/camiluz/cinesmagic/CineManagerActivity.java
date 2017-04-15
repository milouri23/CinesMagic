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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cine_manager);

        // Creación de la cartelera de cine con ayuda de la clase película
        final ArrayList<Pelicula> cartelera = new ArrayList<Pelicula>();
        // Película 1
        cartelera.add(new Pelicula(getString(R.string.titulo_1), R.drawable.cartel_ghost, false,
                6.8f, getString(R.string.sinopsis_titulo_1), R.drawable.trailer_ghost,
                getString(R.string.trailer_titulo_1), 107, new String[]{"15:30", "18:05", "21:00"}));
        // Película 2
        cartelera.add(new Pelicula(getString(R.string.titulo_2), R.drawable.cartel_logan,
                false, 8.5f, getString(R.string.sinopsis_titulo_2), R.drawable.trailer_logan,
                getString(R.string.trailer_titulo_2), 141, new String[]{"14:20", "17:55", "20:32"}));
        // Película 3
        cartelera.add(new Pelicula(getString(R.string.titulo_3), R.drawable.cartel_power,
                true, 6.9f, getString(R.string.sinopsis_titulo_3), R.drawable.trailer_power,
                getString(R.string.trailer_titulo_3), 124, new String[]{"15:30", "18:05", "21:00"}));
        // Película 4
        cartelera.add(new Pelicula(getString(R.string.titulo_4), R.drawable.cartel_life, false, 7,
                getString(R.string.sinopsis_titulo_4), R.drawable.trailer_life,
                getString(R.string.trailer_titulo_4), 104, new String[]{"15:30", "18:05", "21:00"} ));
        // Pelicula 5
        cartelera.add(cartelera.get(3).cambiarFormato(new String[]{"14:25", "16:30", "18:35"}));

        // Se adapta cada item según movie_item.xml a la cuadríacula dentro de activity_cine_manager
        GridView diseñoCuadricula = (GridView) findViewById(R.id.diseño_cuadricula);
        PeliculaAdapter adaptadorDePeliculas = new PeliculaAdapter(this, cartelera);
        diseñoCuadricula.setAdapter(adaptadorDePeliculas);

        // Se lanza la actividad DetallesActivity cuando se hace click en algún item de la cuadrícula
        // pasándole como información extra la película asociada a ese item
        diseñoCuadricula.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CineManagerActivity.this, DetallesActivity.class);
                Pelicula pelicula_escogida = cartelera.get(position);
                intent.putExtra(EXTRA_PELICULA, pelicula_escogida);
                startActivity(intent);
            }
        });
    }
}