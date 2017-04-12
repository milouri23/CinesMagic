package com.pmovil.camiluz.cinesmagic;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by Camilo on 12/04/2017.
 */

public class Pelicula {
    private static int MAX_CALIFICACION = 5;
    private static int MIN_CALIFICACION = 0;

    private String mTitulo;

    private int imageCartelResourceId;
    private int imageTrailerResourceId;

    /** Calificación de 1 a 5 */
    private float mCalificacion;

    private String mSinopsis;
    private Uri mPeticionVideo;
    private boolean mEstaEn2D;
    private boolean mEstaEn3D;

    /* duración en minutos **/
    private int mDuracion;
    private ArrayList<String> mHorasProyeccion = new ArrayList<String>();

    public Pelicula (String titulo, int imageCartelResourceId, boolean estaEn2D, boolean estaEn3D) {
        mTitulo = titulo;
        imageCartelResourceId = imageCartelResourceId;
        mEstaEn2D = estaEn2D;
        mEstaEn3D = estaEn3D;
    }

    public Pelicula(String titulo, int imageCartelResourceId, float calificacion, String sinopsis, String enlaceVideo,
                    boolean estaEn2D, boolean estaEn3D, int duracion,
                    String[] horasProyeccion){

        this(titulo, imageCartelResourceId, estaEn2D, estaEn3D);
        setCalificacion(calificacion);
        mSinopsis = sinopsis;
        mPeticionVideo = Uri.parse(enlaceVideo);
        mDuracion = duracion;
        setHorasProyeccion(horasProyeccion);
    }

    private void setCalificacion(float calificacion) {
        calificacion = calificacion > MAX_CALIFICACION ? MAX_CALIFICACION :
                calificacion < MIN_CALIFICACION ? MIN_CALIFICACION : calificacion;
    }

    private void setHorasProyeccion(String[] horasProyeccion) {

    }

}
