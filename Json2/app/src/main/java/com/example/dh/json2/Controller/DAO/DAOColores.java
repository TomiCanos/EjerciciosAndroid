package com.example.dh.json2.Controller.DAO;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.dh.json2.Model.Color;
import com.example.dh.json2.Model.ListColores;
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

public class DAOColores {

    public List<Color> obtenerListaDeColoresDeArchivo(Context context) throws IOException {
        List<Color> colors = new ArrayList<>();
        AssetManager manager = context.getAssets();
        InputStream archivoJson = manager.open("Colores.json");
        BufferedReader bufferedReaderIn = new BufferedReader(new InputStreamReader(archivoJson));

        Gson gson = new Gson();
        ListColores listColores = gson.fromJson(bufferedReaderIn, ListColores.class);
        colors = listColores.getColors();
        return colors;
    }
}
