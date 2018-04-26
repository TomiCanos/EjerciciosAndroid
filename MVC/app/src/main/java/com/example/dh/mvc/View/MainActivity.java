package com.example.dh.mvc.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dh.mvc.Controller.ControllerNoticias;
import com.example.dh.mvc.R;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button botonMostrarNoticia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMostrarNoticia = findViewById(R.id.button_mostrar_noticia);
        botonMostrarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerNoticias controllerNoticias = new ControllerNoticias();
                try {
                    Toast.makeText(MainActivity.this, controllerNoticias.recibirNoticias(MainActivity.this).toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
