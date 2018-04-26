package com.example.dh.mvc.Model;

/**
 * Created by DH on 25/4/2018.
 */

public class Noticia{
    private String title;
    private String date;
    private String description;
    private String author;

    @Override
    public String toString() {
        return "Noticia{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Noticia(String titulo, String fecha, String descripcion, String autor) {
        this.title = titulo;
        this.date = fecha;
        this.description = descripcion;
        this.author = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
