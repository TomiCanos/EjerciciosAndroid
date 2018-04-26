package com.example.dh.json2.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dh.json2.Controller.ControllerColores;
import com.example.dh.json2.R;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button botonMostrarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonMostrarColor = findViewById(R.id.button_mostrar_color);
        botonMostrarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerColores controllerColores = new ControllerColores();
                try {
                    Toast.makeText(MainActivity.this, controllerColores.recibirColor(MainActivity.this).toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
