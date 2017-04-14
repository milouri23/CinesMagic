package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ReservasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ReservasLayout = inflater.inflate(R.layout.fragment_reservas, container, false);

        Pelicula pelicula = DetallesActivity.pelicula;
        TextView tituloPelicula = (TextView) ReservasLayout.findViewById(R.id.titulo_pelicula);
        ImageView imagenReserva = (ImageView) ReservasLayout.findViewById(R.id.cartel_reservas_imagen);

        tituloPelicula.setText(pelicula.getTitulo());
        imagenReserva.setImageResource(pelicula.getImageCartelResourceId());
        return ReservasLayout;
    }

}