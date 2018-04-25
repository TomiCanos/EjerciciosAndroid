package com.example.pyaya.app_pelis_pedro;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity implements FragmentDetalle.RecibirSerieDesdeElDetalle {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        fragmentDetalle.setArguments(bundle);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.containerMainActivityFragment2, fragmentDetalle);

        fragmentTransaction.commit();
        

    }

    @Override
    public void recibirSerieDesdeElDetalle(Serie serie) {

    }

   /* @Override
    public void abrirDetalleContactoClickeado2(Serie serie) {
        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalle.CLAVE_SERIE_DETALLE,serie);
        fragmentDetalle.setArguments(bundle);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.containerMainActivityFragment2, fragmentDetalle);

        fragmentTransaction.commit();
    }*/
}
