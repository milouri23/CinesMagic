package com.pmovil.camiluz.cinesmagic;

import android.net.Uri;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


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

    String salidaDeCartelera;

    public Pelicula (String titulo, int imageCartelResourceId, boolean estaEn3D) {
        mTitulo = titulo;
        mImageCartelResourceId = imageCartelResourceId;
        setFormato(estaEn3D);
    }

    public Pelicula(String titulo, int imageCartelResourceId, boolean estaEn3D,
                    float calificacion, String sinopsis, int imageTrailerResourceId, String urlVideo,
                    int duracion, String[] horasProyeccion){

        this(titulo, imageCartelResourceId, estaEn3D);
        setCalificacion(calificacion);
        mSinopsis = sinopsis;
        mUrlVideo = urlVideo;
        mDuracion = duracion;
        mImageTrailerResourceId = imageTrailerResourceId;
        setHorasProyeccion(horasProyeccion);
    }

    private void setFormato(boolean estaEn3D) {
        mEstaEn3D = estaEn3D;
        mEstaEn2D = !estaEn3D;
    }

    private void setCalificacion(float calificacion) {
        mCalificacion = calificacion > MAX_CALIFICACION ? MAX_CALIFICACION :
                calificacion < MIN_CALIFICACION ? MIN_CALIFICACION : calificacion;
    }

    /** Almacenar las horas de proyección pasadas a la variable mHorasProyeccion */
    public void setHorasProyeccion(String[] horasProyeccion) {
        for(String horaProyeccion : horasProyeccion) {
            mHorasProyeccion.add(horaProyeccion);
        }
    }

    public String[] getHorasProyeccion() {
        String[] horasProyeccion = new String[mHorasProyeccion.size()];
        for(int index = 0; index < mHorasProyeccion.size(); index++) {
            horasProyeccion[index] = mHorasProyeccion.get(index);
        }
        return horasProyeccion;
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
        String mensaje = mEstaEn3D ? getTitulo() + " (3D)" : getTitulo() + " (2D)";
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
