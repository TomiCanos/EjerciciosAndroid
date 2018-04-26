package com.example.dh.json2.Controller;

import android.content.Context;

import com.example.dh.json2.Controller.DAO.DAOColores;
import com.example.dh.json2.Model.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class ControllerColores {

    public boolean hayInternet() {
        return false;
    }

    public List<Color> recibirColor(Context context) throws IOException {
        List<Color> list = new ArrayList<>();
        if (hayInternet()) {
            DAOColores daoColores = new DAOColores();
            list = daoColores.obtenerListaDeColoresDeArchivo(context);
        } else {

        }
        return list;
    }
}
