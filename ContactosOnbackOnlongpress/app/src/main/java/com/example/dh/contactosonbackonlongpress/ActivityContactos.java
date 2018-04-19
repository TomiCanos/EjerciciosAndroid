package com.example.dh.contactosonbackonlongpress;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ActivityContactos extends AppCompatActivity implements FragmentAgregarContacto.RecibidorCancelacion, FragmentListaContactos.RecibidorAgregar, FragmentAgregarContacto.RecibidorContactoTerminado{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        FragmentListaContactos fragmentListaContactos = new FragmentListaContactos();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_activity_container, fragmentListaContactos);
        transaction.commit();

    }

    @Override
    public void recibirCancelacion() {
        onBackPressed();

    }

    @Override
    public void recibirAgregar() {
        FragmentAgregarContacto fragmentAgregarContacto = new FragmentAgregarContacto();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_container, fragmentAgregarContacto);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void RecibirContacto(Contacto contacto) {

    }
}


