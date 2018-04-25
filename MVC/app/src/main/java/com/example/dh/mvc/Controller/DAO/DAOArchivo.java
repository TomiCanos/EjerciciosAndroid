package com.example.dh.mvc.Controller.DAO;

import com.example.dh.mvc.Model.Noticia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class DAOArchivo {

    public List<Noticia> obtenerListaDeNoticiasDeArchivo(){
        List<Noticia> lista = new ArrayList<>();
        Noticia noticia = new Noticia("chau", "10-10-2017", "nos vemos", "yo");
        lista.add(noticia);
        return lista;
    }
}
