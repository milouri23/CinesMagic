package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class ReservasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ReservasLayout = inflater.inflate(R.layout.fragment_reservas, container, false);

        Date fecha = new Date();
        String[] arregloFecha = fecha.toString().split(" ");
        String mesDiaActual = arregloFecha[1] + " " + arregloFecha[2];

        Log.v("ReservasFragment", fecha.toString());
        Log.v("ReservasFragment", mesDiaActual);
        Pelicula pelicula = DetallesActivity.pelicula;
        TextView tituloPelicula = (TextView) ReservasLayout.findViewById(R.id.titulo_pelicula);
        ImageView imagenReserva = (ImageView) ReservasLayout.findViewById(R.id.cartel_reservas_imagen);
        Button botonDia1 = (Button) ReservasLayout.findViewById(R.id.boton_dia_1);

        botonDia1.setText(mesDiaActual);
        tituloPelicula.setText(pelicula.getTitulo());
        imagenReserva.setImageResource(pelicula.getImageCartelResourceId());
        return ReservasLayout;
    }

}