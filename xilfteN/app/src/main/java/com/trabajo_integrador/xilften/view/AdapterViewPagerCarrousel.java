package com.trabajo_integrador.xilften.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.trabajo_integrador.xilften.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPagerCarrousel extends FragmentStatePagerAdapter {

    private List<Fragment> listaPeliculasFragment;

    public AdapterViewPagerCarrousel(FragmentManager fm, List<Pelicula> peliculas) {
        super(fm);
        listaPeliculasFragment = new ArrayList<>();

        List<Pelicula> listaDePelis = peliculas;

            //for(int i = 0; i < 5; i++) {


        for (int i = 0; i < 7; i++)    {
            //FragmentDetalle fragmentDetalle = FragmentDetalle.fabricaFragmentPelicula(pelicula);
           FragmentCarrousel fragmentCarrousel = FragmentCarrousel.fabricaDeSliderCarrousel(peliculas.get(i));

           listaPeliculasFragment.add(fragmentCarrousel);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return listaPeliculasFragment.get(position);
    }

    @Override
    public int getCount() {
        return listaPeliculasFragment.size();
    }

}