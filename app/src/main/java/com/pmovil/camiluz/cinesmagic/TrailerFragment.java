package com.pmovil.camiluz.cinesmagic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class TrailerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View trailerLayout = inflater.inflate(R.layout.fragment_trailer, container, false);;
        ImageView trailerImage = (ImageView) trailerLayout.findViewById(R.id.trailer_imagen);
        trailerImage.setImageResource(DetallesActivity.pelicula.getImagenTrailer());
        ImageButton trailerBoton = (ImageButton) trailerLayout.findViewById(R.id.trailer_button);
        trailerBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(DetallesActivity.pelicula.getUrlVideo())));
            }
        });
        return trailerLayout;
    }
}