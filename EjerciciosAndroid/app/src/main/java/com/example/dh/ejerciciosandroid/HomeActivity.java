package com.example.dh.ejerciciosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    public static final String CLAVE_NOMBRE = "CLAVE_NOMBRE";
    public static final String CLAVE_EDAD = "CLAVE_EDAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nombre = bundle.getString(CLAVE_NOMBRE);
        String edad = bundle.getString(CLAVE_EDAD);
        Toast.makeText(this, "Nombre: " + nombre + " Edad: " + edad, Toast.LENGTH_SHORT).show();
    }
}
