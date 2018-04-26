package com.example.dh.mvc.Controller.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.dh.mvc.Model.ListNoticias;
import com.example.dh.mvc.Model.Noticia;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DH on 25/4/2018.
 */

public class DAOArchivo {

    public List<Noticia> obtenerListaDeNoticiasDeArchivo(Context context) throws IOException {
        List<Noticia> noticias = new ArrayList<>();
        AssetManager manager = context.getAssets();
        InputStream archivoJson = manager.open("Noticia.json");
        BufferedReader bufferedReaderin = new BufferedReader(new InputStreamReader(archivoJson));

        Gson gson = new Gson();
        ListNoticias listNoticias = gson.fromJson(bufferedReaderin, ListNoticias.class);
        noticias = listNoticias.getNoticias();

        return noticias;
    }
}
