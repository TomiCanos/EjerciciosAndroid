package com.trabajo_integrador.xilften.view;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.trabajo_integrador.xilften.controller.PeliculaController;
import com.trabajo_integrador.xilften.model.Pelicula;
import com.trabajo_integrador.xilften.R;
import com.trabajo_integrador.xilften.model.Serie.Serie;
import com.trabajo_integrador.xilften.utils.ResultListener;

import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements FragmentHome.Notificable, FragmentGenero.NotificableGenero, FragmentHome.ReceptorSerie {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.xilften);



        final FragmentHome fragmentHome = new FragmentHome();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.contenedor_fragment_home, fragmentHome);

        fragmentTransaction.commit();

        //MENU DESPLEGABLE DE COSTADO:
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contenedor_fragment_home);

                switch (item.getItemId()) {
                    case R.id.navigationItemAccion:
                        //if (!(fragment instanceof FragmentGenero)) {
                            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                getSupportFragmentManager().popBackStack();
                            }
                            cargadorDeGenero(28);
                        //}

                        break;
                    case R.id.navigationItemAventura:
                      //  if (!(fragment instanceof FragmentGenero)) {
                            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                getSupportFragmentManager().popBackStack();
                            }
                            cargadorDeGenero(12);
                     //   }
                        break;
                    case R.id.navigationItemAnimacion:
                       // if (!(fragment instanceof FragmentGenero)) {
                            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                getSupportFragmentManager().popBackStack();
                            }
                            cargadorDeGenero(16);
                     //   }
                        break;
                    case R.id.navigationItemComedia:
                    //    if (!(fragment instanceof FragmentGenero)) {
                            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                getSupportFragmentManager().popBackStack();
                            }
                            cargadorDeGenero(35);
                       // }
                        break;
                    case R.id.navigationItemCienciaFiccion:
                      //  if (!(fragment instanceof FragmentGenero)) {
                            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                                getSupportFragmentManager().popBackStack();
                            }
                            cargadorDeGenero(14);
                       // }
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_id:
                Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.home_id:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.fav_id:
                // Intent intent = new Intent(this, ActivityFavourites.class);
                // startActivity(intent);
                return true;
            case android.R.id.home:
                //listener personalizado para la flechita de ir hacia atras
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cargadorDeGenero(Integer unGenero) {

        FragmentGenero fragmentGenero = FragmentGenero.fabricaFragmentGenero(unGenero);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_fragment_home, fragmentGenero);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void abrirDetalleContactoClickeado(List<Pelicula> peliculas, Integer positionPelicula) {

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleActivity.CLAVE_PELICULA, (Serializable) peliculas);
        bundle.putInt(DetalleActivity.ID_POSITION, positionPelicula);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void abrirDetalleSerieClickeado(List<Serie> series, Integer positionSerie) {
        Intent intent = new Intent(MainActivity.this, DetalleActivitySerie.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetalleActivitySerie.CLAVE_SERIE, (Serializable) series);
        bundle.putInt(DetalleActivitySerie.ID_POSITION, positionSerie);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.contenedor_fragment_home);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                if (currentFragment instanceof FragmentGenero) {
                    for (int i = 0; i < 5; i++) {
                        navigationView.getMenu().getItem(i).setChecked(false);
                    }
                }
            } else {
                super.onBackPressed();
            }
            super.onBackPressed();
        }
    }



}