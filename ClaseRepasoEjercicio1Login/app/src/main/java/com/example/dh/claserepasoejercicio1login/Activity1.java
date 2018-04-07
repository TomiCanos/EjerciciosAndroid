package com.example.dh.claserepasoejercicio1login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity1 extends AppCompatActivity implements FragmentLoginOCrear.NotificarAActivities{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        FragmentLoginOCrear fragmentLoginOCrear = new FragmentLoginOCrear();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity1_container, fragmentLoginOCrear);
        transaction.commit();

    }

    @Override
    public void recibirMensaje(String mensaje) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (mensaje.equals("clickeastelogin")){
            FragmentLogin fragmentLogin = new FragmentLogin();
            transaction.replace(R.id.activity1_container, fragmentLogin);
            transaction.commit();
        }else if (mensaje.equals("clickeastecrear")){
            FragmentCrear fragmentCrear = new FragmentCrear();
            transaction.replace(R.id.activity1_container, fragmentCrear);
            transaction.commit();
        }
    }
}
