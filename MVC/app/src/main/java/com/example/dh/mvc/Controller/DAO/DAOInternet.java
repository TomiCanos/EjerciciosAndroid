package com.example.dh.mvc.Controller.DAO;

import com.example.dh.mvc.Model.Noticia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class DAOInternet {

    public List<Noticia> obtenerListaDeNoticiasDeInternet(){
        List<Noticia> lista = new ArrayList<>();
        Noticia noticia = new Noticia("hola", "10-10-2019", "que tal", "yo");
        lista.add(noticia);
        return lista;
    }
}
