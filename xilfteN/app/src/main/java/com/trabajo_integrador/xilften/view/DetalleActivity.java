package com.trabajo_integrador.xilften.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.trabajo_integrador.xilften.model.Pelicula;
import com.trabajo_integrador.xilften.R;

import java.util.List;

public class DetalleActivity extends AppCompatActivity {

    public static final String CLAVE_PELICULA = "CLAVE_PELICULA";
    public static final String ID_POSITION = "ID_POSITION";
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setLogo(R.drawable.xilften);



        ViewPager viewPager = findViewById(R.id.detalle_view_pager);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Integer positionAdapter = bundle.getInt(ID_POSITION);
        List<Pelicula> listaPeliculas = (List<Pelicula>) bundle.getSerializable(CLAVE_PELICULA);

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), listaPeliculas); //listaRecetas //getSupportFragmentManager(),fragmentColorList

        viewPager.setAdapter(adapterViewPager);
        viewPager.setCurrentItem(positionAdapter);

        viewPager.setPageTransformer(true, new CubeTransformer());

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
}