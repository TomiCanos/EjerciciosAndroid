package com.example.dh.mvc.Controller;

import android.content.Context;

import com.example.dh.mvc.Controller.DAO.DAOArchivo;
import com.example.dh.mvc.Controller.DAO.DAOInternet;
import com.example.dh.mvc.Model.Noticia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class ControllerNoticias {

    public List<Noticia> recibirNoticias(Context context) throws IOException {
        List<Noticia> list = new ArrayList<>();
        if (hayInternet()) {
            DAOInternet daoInternet = new DAOInternet();
            list = daoInternet.obtenerListaDeNoticiasDeInternet(context);
        } else {
            DAOArchivo daoArchivo = new DAOArchivo();
            list = daoArchivo.obtenerListaDeNoticiasDeArchivo(context);
        }
        return list;
    }

    public boolean hayInternet() {
        return false;
    }
}
