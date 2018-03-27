package com.example.dh.comuncacionactivitiesej1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SenderActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private Button botonMandar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        nombre = findViewById(R.id.sender_txtedit_nombre);
        apellido = findViewById(R.id.sender_txtedit_apellido);
        edad = findViewById(R.id.sender_txtedit_edad);
        botonMandar = findViewById(R.id.sender_button_mandar);
        botonMandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SenderActivity.this, ReceptorActivity.class);
                String nombreIngresado = nombre.getText().toString();
                String apellidoIngresado = apellido.getText().toString();
                String edadIngresada = edad.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(ReceptorActivity.CLAVE_NOMBRE, nombreIngresado);
                bundle.putString(ReceptorActivity.CLAVE_APELLIDO, apellidoIngresado);
                bundle.putString(ReceptorActivity.CLAVE_EDAD, edadIngresada);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
