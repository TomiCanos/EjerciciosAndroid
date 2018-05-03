package com.example.oem.entregableandroidcore;

import java.util.ArrayList;
import java.util.List;

public class BaseDeRecetas {
    public List<Receta> traerListaDeRecetas(){
        List<Receta> recetas = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Receta receta = new Receta("Milanga Napo", R.drawable.milanapo, "carne, pan rallado, huevos, aceite, sal", "Cortas una feta de carne. La pasas suavemente por el huevo con sal batido, y luego por el pan. Inmediatamente la amasijas a piñas para que se le pegue el pan y al aceite un ratito. Queda joya");
            recetas.add(receta);
            Receta receta1 = new Receta("Fideos", R.drawable.fideos, "Fideos, agua, aceite, sal", "le tiras aceite y sal al agua. Abris el paquete de fideos y lo tiras que mas queres");
            recetas.add(receta1);
            Receta receta2 = new Receta("Flan", R.drawable.flan, "Azucar, flan instantaneo, leche", "Usas el polvito del flan de exquisita y le tiras leche y azucar. lo dejas cocinar un rato y le tiras el azucar cocinado previamente por tu mama");
            recetas.add(receta2);
            Receta receta3 = new Receta("Huevos Fritos", R.drawable.huevosfritos, "Huevos, aceite, sal, pimienta", "Tiras el aceite y despues el huevo encima. al rato le metes sal y pimienta. Lo cocinas hasta que te quede lindo y te lo comes");
            recetas.add(receta3);
            Receta receta4 = new Receta("Tarta de Manzana", R.drawable.tartamanzana, "Manzanas, azucar, torta", "Haces una torta y le tiras fetitas de manzana caramelizada arriba y te queda una torta que parece de manzana pero engaña pichanga");
            recetas.add(receta4);
            Receta receta5 = new Receta("Ñoquis", R.drawable.noquis, "Papa, leche, sal, harina", "Haces pure de papa, y despues le tiras harina encima. Le tocas la jalea hasta que quede hecho una masa. Armas tiritas y lo cortas en pedacitos. Sal, agua, aceite y nv");
            recetas.add(receta5);
        }
        return recetas;
    }
}
