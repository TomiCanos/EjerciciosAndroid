package com.example.dh.contactosonbackonlongpress;

import android.widget.ImageView;

/**
 * Created by DH on 18/4/2018.
 */

public class Contacto {
    private ImageView foto;
    private String nombre;
    private String descripcion;

    public Contacto(ImageView foto, String nombre, String descripcion) {
        this.foto = foto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
