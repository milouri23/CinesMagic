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
import android.widget.Toast;

import java.util.Date;

public class ReservasFragment extends Fragment {

    private int cantidadReservas = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View reservasLayout = inflater.inflate(R.layout.fragment_reservas, container, false);

        final long miliEn1Dia = 86400000;
        Date fechaHoy = new Date();
        Date fechaManana = new Date(fechaHoy.getTime() + miliEn1Dia);
        Date fechaPasadoManana = new Date(fechaManana.getTime() + miliEn1Dia);

        Log.v("ReservasFragment", fechaHoy.toString());
        final int MIN_RESERVAS = 1;
        final int MAX_RESERVAS = 5;

        Pelicula pelicula = DetallesActivity.pelicula;
        ImageView imagenReserva = (ImageView) reservasLayout.findViewById(R.id.cartel_reservas_imagen);
        TextView tituloPelicula = (TextView) reservasLayout.findViewById(R.id.titulo_pelicula);
        final TextView fechaSeleccionada = (TextView) reservasLayout.findViewById(R.id.fecha_seleccionada);
        final Button[] botonesDias = {(Button) reservasLayout.findViewById(R.id.boton_dia_1),
                (Button) reservasLayout.findViewById(R.id.boton_dia_2),
                (Button) reservasLayout.findViewById(R.id.boton_dia_3)};
        Button botonDecremento = (Button) reservasLayout.findViewById(R.id.boton_decremento);
        Button botonIncremento = (Button) reservasLayout.findViewById(R.id.boton_incremento);
        final TextView cantidadTextView = (TextView) reservasLayout.findViewById(R.id.text_view_cantidad);

        botonDecremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadReservas == MIN_RESERVAS) {
                    String warning = "No puedes reservar menos de " + MIN_RESERVAS + " boletas";
                    Toast.makeText(getContext(), warning, Toast.LENGTH_SHORT).show();
                    return;
                }
                cantidadTextView.setText(Integer.toString(--cantidadReservas));
            }
        });

        botonIncremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadReservas == MAX_RESERVAS) {
                    String warning = "No puedes reservar más de " + MAX_RESERVAS + " boletas";
                    Toast.makeText(getContext(), warning, Toast.LENGTH_SHORT).show();
                    return;
                }
                cantidadTextView.setText(Integer.toString(++cantidadReservas));
            }
        });

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
            casillaSeleccion.setTextSize(20);
            casillaSeleccion.setPadding(24, 0, 0, 0);
            casillaSeleccion.performClick();
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
                    fechaSeleccionada.setText(( (Button) v).getText());
                }
            });
        }

        botonesDias[0].performClick();

        return reservasLayout;
    }
    private String obtenerMesDia(Date fecha) {
        String[] arregloFecha = fecha.toString().split(" ");
        return arregloFecha[1] + " " + arregloFecha[2];
    }
}