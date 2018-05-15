package com.trabajo_integrador.xilften.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trabajo_integrador.xilften.model.Pelicula;
import com.trabajo_integrador.xilften.R;

import java.util.List;

public class DetalleActivity extends AppCompatActivity {

    public static final String CLAVE_PELICULA = "CLAVE_PELICULA";
    public static final String ID_POSITION = "ID_POSITION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ViewPager viewPager = findViewById(R.id.detalle_view_pager);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Integer positionAdapter = bundle.getInt(ID_POSITION);
        List<Pelicula> listaPeliculas = (List<Pelicula>) bundle.getSerializable(CLAVE_PELICULA);

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), listaPeliculas); //listaRecetas //getSupportFragmentManager(),fragmentColorList

        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(positionAdapter);

        viewPager.setPageTransformer(true, new CubeTransformer());

    }

}