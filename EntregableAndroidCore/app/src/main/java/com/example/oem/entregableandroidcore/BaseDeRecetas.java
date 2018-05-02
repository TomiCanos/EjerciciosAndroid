package com.example.oem.entregableandroidcore;

import java.util.ArrayList;
import java.util.List;

public class BaseDeRecetas {
    public List<Receta> traerListaDeRecetas(){
        List<Receta> recetas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Receta receta = new Receta("Milanga Napo", R.drawable.borago, "pasto, cemento, ganas", "al trompito y le tiras");
            recetas.add(receta);
        }
        return recetas;
    }
}
