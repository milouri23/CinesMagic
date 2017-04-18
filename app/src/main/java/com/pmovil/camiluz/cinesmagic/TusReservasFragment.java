package com.pmovil.camiluz.cinesmagic;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TusReservasFragment extends Fragment {


    public TusReservasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layoutTusReservas = inflater.inflate(R.layout.fragment_tus_reservas, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("ReservasPreferences", Context.MODE_PRIVATE);

        final TextView reservaTitulo = (TextView) layoutTusReservas.findViewById(R.id.reserva_titulo);
        final TextView reservaFecha = (TextView) layoutTusReservas.findViewById(R.id.reserva_fecha);
        final TextView reservaHora = (TextView) layoutTusReservas.findViewById(R.id.reserva_hora);
        final TextView reservaCantidad = (TextView) layoutTusReservas.findViewById(R.id.reserva_cantidad);
        Button botonEliminar = (Button) layoutTusReservas.findViewById(R.id.boton_eliminar);

        reservaTitulo.setText(sharedPreferences.getString("reserva_titulo", ""));
        reservaFecha.setText(sharedPreferences.getString("reserva_dia", ""));
        reservaHora.setText(sharedPreferences.getString("reserva_hora",""));
        reservaCantidad.setText(String.valueOf(sharedPreferences.getInt("reserva_cantidad", 0)) + " Asientos");

        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences(
                        "ReservasPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().commit();
                reservaTitulo.setText("");
                reservaFecha.setText("Usted no tiene reservas");
                reservaHora.setText("");
                reservaCantidad.setText("");

            }
        });
        return layoutTusReservas;
    }


}
