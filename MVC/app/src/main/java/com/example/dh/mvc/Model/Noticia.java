package com.example.dh.mvc.Model;

/**
 * Created by DH on 25/4/2018.
 */

public class Noticia{
    private String titulo;
    private String fecha;
    private String descripcion;
    private String autor;

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public Noticia(String titulo, String fecha, String descripcion, String autor) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
