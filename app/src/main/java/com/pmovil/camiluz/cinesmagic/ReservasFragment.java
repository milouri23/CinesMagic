package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class ReservasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View reservasLayout = inflater.inflate(R.layout.fragment_reservas, container, false);

        final long miliEn1Dia = 86400000;
        Date fechaHoy = new Date();
        Date fechaManana = new Date(fechaHoy.getTime() + miliEn1Dia);
        Date fechaPasadoManana = new Date(fechaManana.getTime() + miliEn1Dia);

        Log.v("ReservasFragment", fechaHoy.toString());

        final int colorResourceId = android.R.color.background_dark;
        Pelicula pelicula = DetallesActivity.pelicula;
        TextView tituloPelicula = (TextView) reservasLayout.findViewById(R.id.titulo_pelicula);
        ImageView imagenReserva = (ImageView) reservasLayout.findViewById(R.id.cartel_reservas_imagen);

        final Button[] botonesDias = {(Button) reservasLayout.findViewById(R.id.boton_dia_1),
                (Button) reservasLayout.findViewById(R.id.boton_dia_2),
                (Button) reservasLayout.findViewById(R.id.boton_dia_3)};
        botonesDias[0].setText(obtenerMesDia(fechaHoy));
        botonesDias[1].setText(obtenerMesDia(fechaManana));
        botonesDias[2].setText(obtenerMesDia(fechaPasadoManana));
        tituloPelicula.setText(pelicula.toString());
        imagenReserva.setImageResource(pelicula.getImageCartelResourceId());

        RadioGroup grupoCasillas = (RadioGroup) reservasLayout.findViewById(R.id.grupo_de_casillas);
        for(String horarioProyeccion:pelicula.getHorasProyeccion()) {
            RadioButton casillaSeleccion = new RadioButton(getContext());
            casillaSeleccion.setText(horarioProyeccion);
            grupoCasillas.addView(casillaSeleccion);
        }

        for (Button botonDia:botonesDias) {
            botonDia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (Button botonDia:botonesDias) {
                        if ((Button) v == botonDia) {
                            botonDia.setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.black));
                        } else {
                            botonDia.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
                        }
                    }
                }
            });
        }
        return reservasLayout;
    }

    private String obtenerMesDia(Date fecha) {
        String[] arregloFecha = fecha.toString().split(" ");
        return arregloFecha[1] + " " + arregloFecha[2];
    }

}