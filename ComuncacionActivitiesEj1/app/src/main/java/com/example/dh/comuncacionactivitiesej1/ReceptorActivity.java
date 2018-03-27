package com.example.dh.comuncacionactivitiesej1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceptorActivity extends AppCompatActivity {

    public static final String CLAVE_NOMBRE = "CLAVE_NOMBRE";
    public static final String CLAVE_APELLIDO = "CLAVE_APELLIDO";
    public static final String CLAVE_EDAD = "CLAVE_EDAD";
    private TextView nombreIngresado;
    private TextView apellidoIngresado;
    private TextView edadIngresada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor);
        nombreIngresado = findViewById(R.id.receptor_txtview_nombre_ingresado);
        apellidoIngresado = findViewById(R.id.receptor_txtview_apellido_ingresado);
        edadIngresada = findViewById(R.id.receptor_txtview_edad_ingresada);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nombre = bundle.getString(CLAVE_NOMBRE);
        String apellido = bundle.getString(CLAVE_APELLIDO);
        String edad = bundle.getString(CLAVE_EDAD);
        nombreIngresado.setText(nombre);
        apellidoIngresado.setText(apellido);
        edadIngresada.setText(edad);
    }
}
