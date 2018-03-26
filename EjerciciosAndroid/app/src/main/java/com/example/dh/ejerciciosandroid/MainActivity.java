package com.example.dh.ejerciciosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView botonEnviar;
    private EditText nombre;
    private EditText edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonEnviar = findViewById(R.id.main_textView_enviar);
        nombre = findViewById(R.id.main_editText_ingresarnombre);
        edad = findViewById(R.id.main_editText_ingresaredad);
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                String nombreIngresado = nombre.getText().toString();
                String edadIngresada = edad.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(HomeActivity.CLAVE_NOMBRE, nombreIngresado);
                bundle.putString(HomeActivity.CLAVE_EDAD, edadIngresada);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
