package com.pmovil.camiluz.cinesmagic;

import android.net.Uri;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class Pelicula implements Serializable {
    private static int MAX_CALIFICACION = 5;
    private static int MIN_CALIFICACION = 0;

    private String mTitulo;

    private int mImageCartelResourceId;
    private int mImageTrailerResourceId;

    /** Calificación de MIN_CALIFICACION a MAX_CALIFICACION */
    private float mCalificacion;

    private String mSinopsis;
    private String mUrlVideo;
    private boolean mEstaEn2D;
    private boolean mEstaEn3D;

    /* duración en minutos **/
    private int mDuracion;
    private ArrayList<String> mHorasProyeccion = new ArrayList<String>();

    public Pelicula (String titulo, int imageCartelResourceId, boolean estaEn2D, boolean estaEn3D) {
        mTitulo = titulo;
        mImageCartelResourceId = imageCartelResourceId;
        mEstaEn2D = estaEn2D;
        mEstaEn3D = estaEn3D;
    }

    public Pelicula(String titulo, int imageCartelResourceId, boolean estaEn2D, boolean estaEn3D,
                    float calificacion, String sinopsis, int imageTrailerResourceId, String urlVideo,
                    int duracion, String[] horasProyeccion){

        this(titulo, imageCartelResourceId, estaEn2D, estaEn3D);
        setCalificacion(calificacion);
        mSinopsis = sinopsis;
        mUrlVideo = urlVideo;
        mDuracion = duracion;
        mImageTrailerResourceId = imageTrailerResourceId;
        setHorasProyeccion(horasProyeccion);
    }

    public void setCalificacion(float calificacion) {
        mCalificacion = calificacion > MAX_CALIFICACION ? MAX_CALIFICACION :
                calificacion < MIN_CALIFICACION ? MIN_CALIFICACION : calificacion;
    }

    public void setHorasProyeccion(String[] horasProyeccion) {

    }

    public int getImagenTrailer() {
        return mImageTrailerResourceId;
    }

    public int getImageCartelResourceId() {
        return mImageCartelResourceId;
    }

    public String getUrlVideo() {
        return mUrlVideo;
    }

    public String getTitulo() {
        return mTitulo;
    }

    /** Nombre de la película(formatos) */
    @Override
    public String toString() {
        // StringBuilder pelicula = new StringBuilder(50);
        String mensaje = mTitulo + " (";
        if(mEstaEn3D) {
            // Ghost in the shell (3D 2D)
            mensaje += " 3D ";
        }
        if(mEstaEn2D) {
            mensaje += " 2D ";
        }
        mensaje += ")";

        return mensaje;
    }

    public String getSinopsis() {
        return mSinopsis;
    }

    public int getDuracion() {
        return mDuracion;
    }

    public float getCalificacion() {
        return mCalificacion;
    }
}
