package com.pmovil.camiluz.cinesmagic;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Camilo on 12/04/2017.
 */

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {

    /** Método constructor
     *
     * @param context es la actividad en donde se van a mostrar los items
     * @param peliculas es el arreglo de películas (cartelera) de donde se van a sacar las
     *                  imágenes y el título
     */
    public PeliculaAdapter(Activity context, ArrayList<Pelicula> peliculas) {
        super(context, 0, peliculas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemPelicula = convertView;
        if(itemPelicula == null) {
            itemPelicula = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
        }

        // imagen y texto
        Pelicula peliculaActual = getItem(position);
        TextView nombreDePelicula = (TextView) itemPelicula.findViewById(R.id.nombre_pelicula);
        ImageView imagenDePelicula = (ImageView) itemPelicula.findViewById(R.id.imagen_pelicula);

        nombreDePelicula.setText(peliculaActual.toString());
        imagenDePelicula.setImageResource(peliculaActual.getImageCartelResourceId());

        return itemPelicula;
    }
}



        /*
        final Word currentWord = getItem(position);

        final LinearLayout textContainer = (LinearLayout) gridItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));
        TextView miwokTextView = (TextView) gridItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) gridItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);

        /*
        if(currentWord.hasAudio()) {
            textContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer.create(getContext(), currentWord.getAudioResourceId()).start();
                }
            });
        } */

//}
