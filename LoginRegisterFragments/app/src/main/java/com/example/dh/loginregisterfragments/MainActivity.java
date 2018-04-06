package com.example.dh.loginregisterfragments;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentFormulario.NotificadorAActivities {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentFormulario fragmentFormulario = new FragmentFormulario();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_contenedor_fragmentFormulario, fragmentFormulario);
        fragmentTransaction.commit();
    }

    @Override
    public void RecibirMensaje(String mensaje, String mensaje2) {
        Intent intent = new Intent(this, WelcomeActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("CLAVE_USERNAME", mensaje);
        bundle.putString("CLAVE_PASSWORD", mensaje2);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
