package com.example.dh.mvc.Model;

import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class ListNoticias {
    private List<Noticia> noticias;

    public ListNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}
