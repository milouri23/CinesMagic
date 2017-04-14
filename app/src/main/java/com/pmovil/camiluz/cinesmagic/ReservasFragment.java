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

        final long miliEn1Dia = 86400000;
        Date fechaHoy = new Date();
        Date fechaManana = new Date(fechaHoy.getTime() + miliEn1Dia);
        Date fechaPasadoManana = new Date(fechaManana.getTime() + miliEn1Dia);

        Log.v("ReservasFragment", fechaHoy.toString());

        Pelicula pelicula = DetallesActivity.pelicula;
        TextView tituloPelicula = (TextView) ReservasLayout.findViewById(R.id.titulo_pelicula);
        ImageView imagenReserva = (ImageView) ReservasLayout.findViewById(R.id.cartel_reservas_imagen);
        Button botonDia1 = (Button) ReservasLayout.findViewById(R.id.boton_dia_1);
        Button botonDia2 = (Button) ReservasLayout.findViewById(R.id.boton_dia_2);
        Button botonDia3 = (Button) ReservasLayout.findViewById(R.id.boton_dia_3);

        botonDia1.setText(obtenerMesDia(fechaHoy));
        botonDia2.setText(obtenerMesDia(fechaManana));
        botonDia3.setText(obtenerMesDia(fechaPasadoManana));
        tituloPelicula.setText(pelicula.getTitulo());
        imagenReserva.setImageResource(pelicula.getImageCartelResourceId());
        return ReservasLayout;
    }

    private String obtenerMesDia(Date fecha) {
        String[] arregloFecha = fecha.toString().split(" ");
        return arregloFecha[1] + " " + arregloFecha[2];
    }

}