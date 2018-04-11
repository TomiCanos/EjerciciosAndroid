package com.example.dh.floating1;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity1 extends AppCompatActivity implements FragmentActivity1.NotificadorAActivities{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        FragmentActivity1 fragmentActivity1 = new FragmentActivity1();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_activity1, fragmentActivity1);
        transaction.commit();

    }

    @Override
    public void recibirMensaje(String mensaje, String regalos) {
        Intent intent = new Intent(this, Activity2.class);
        Bundle bundle = new Bundle();
        bundle.putString("CLAVE_MENSAJE", mensaje);
        bundle.putString("CLAVE_REGALOS", regalos);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
