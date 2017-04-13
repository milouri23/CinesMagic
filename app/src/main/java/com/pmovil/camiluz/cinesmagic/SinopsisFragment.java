package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SinopsisFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View sinopsisLayout = inflater.inflate(R.layout.fragment_sinopsis, container, false);

        Pelicula pelicula = DetallesActivity.pelicula;
        TextView titleTextView = (TextView) sinopsisLayout.findViewById(R.id.title_text_view);
        TextView sinopsisTextView = (TextView) sinopsisLayout.findViewById(R.id.sinopsis_text_view);
        TextView duracionTextView = (TextView) sinopsisLayout.findViewById(R.id.duracion_text_view);
        TextView calificacionTextView = (TextView) sinopsisLayout.findViewById(R.id.calificacion_text_view);

        titleTextView.setText(pelicula.getTitulo());
        sinopsisTextView.setText(pelicula.getSinopsis());
        duracionTextView.setText(getString(R.string.valor_duracion, pelicula.getDuracion()));
        calificacionTextView.setText(getString(R.string.valor_calificacion, pelicula.getCalificacion()));

        return sinopsisLayout;
    }

}