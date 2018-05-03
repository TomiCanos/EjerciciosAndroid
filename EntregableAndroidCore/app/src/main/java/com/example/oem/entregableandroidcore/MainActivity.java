package com.example.oem.entregableandroidcore;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FragmentListaRecetas.Notificable2 {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).hide();
        }
        navigationView = findViewById(R.id.navigation_view_main_activity);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigationItemRecetas:
                        if (i == 0){
                        FragmentListaRecetas fragmentRecetas = new FragmentListaRecetas();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().add(R.id.container_main_activity, fragmentRecetas).addToBackStack(null);
                        i++;
                        transaction.commit();}else{i = 0;}
                        break;

                    case R.id.navigationItemAboutUs:
                        Toast.makeText(MainActivity.this, "Abrir AboutUs", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout_main_activity);
    }

    @Override
    public void abrirDetalleReceta2(Receta receta) {
        FragmentDetalleRecetas fragmentDetalleRecetas = new FragmentDetalleRecetas();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragmentDetalleRecetas.CLAVE_RECETA, receta );
        fragmentDetalleRecetas.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.container_main_activity, fragmentDetalleRecetas).addToBackStack(null);
        transaction.commit();
    }
}
