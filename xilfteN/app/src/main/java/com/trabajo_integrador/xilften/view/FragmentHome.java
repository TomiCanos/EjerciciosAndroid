package com.trabajo_integrador.xilften.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.trabajo_integrador.xilften.controller.PeliculaController;
import com.trabajo_integrador.xilften.model.Pelicula;
import com.trabajo_integrador.xilften.R;
import com.trabajo_integrador.xilften.utils.ResultListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentHome extends Fragment {

    private static final String ID_PELICULACARROUSEL = "ID_PELICULACARROUSEL";

    RecyclerView recyclerView;
    private RecyclerView recyclerViewNationals;
    private AdapterTMDB adapterTreinding;
    private AdapterTMDB adapterSerie;
    private AdapterTMDB adapterReleases;
    private AdapterTMDB adapterNational;
    private AdapterTMDB adapterComedy;
    private AdapterTMDB adapterBecauseYouWatched;
    private Notificable notificable;
    private List<Pelicula> listaTrendingResultado;
    private List<Pelicula> listaSeriesResultado;
    private List<Pelicula> listaReleasesResultado;
    private List<Pelicula> listaNationalResultado;
    private List<Pelicula> listaComedyResultado;
    private List<Pelicula> listaTrending;
    private List<Pelicula> listaSeries;
    private List<Pelicula> listaReleases;
    private List<Pelicula> listaNational;
    private List<Pelicula> listaComedy;
    private ViewPager viewPager;
    private Pelicula pelicula;


    public FragmentHome() {

        listaTrendingResultado = new ArrayList<>();
        listaSeriesResultado = new ArrayList<>();
        listaReleasesResultado = new ArrayList<>();
        listaNationalResultado = new ArrayList<>();
        listaComedyResultado = new ArrayList<>();
        listaTrending = new ArrayList<>();
        listaSeries = new ArrayList<>();
        listaReleases = new ArrayList<>();
        listaNational = new ArrayList<>();
        listaComedy = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.viewPagerCarrousel);


       /* AdapterCarrousel adapterCarrousel = new AdapterCarrousel(getActivity());
        viewPager.setAdapter(adapterCarrousel);*/

        crearTrendingLista();




        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new miTimer(), 9000, 8000);

        recyclerView = view.findViewById(R.id.fragment_home_recycler_trending);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterTreinding = new AdapterTMDB(crearTrendingLista(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerView.setAdapter(adapterTreinding);

        //Recycler & AdapterPelicula para Trending Now. @Dani

        RecyclerView recyclerViewTrending = view.findViewById(R.id.fragment_home_recycler_series);
        recyclerViewTrending.setHasFixedSize(true);
        recyclerViewTrending.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterSerie = new AdapterTMDB(crearListaSerie(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerViewTrending.setAdapter(adapterSerie);
        //////////

        RecyclerView recyclerViewReleases = view.findViewById(R.id.fragment_home_recycler_releases);
        recyclerViewReleases.setHasFixedSize(true);
        recyclerViewReleases.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterReleases = new AdapterTMDB(crearListaReleases(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerViewReleases.setAdapter(adapterReleases);
        /////////////////////////

        recyclerViewNationals = view.findViewById(R.id.fragment_home_recycler_national);
        recyclerViewNationals.setHasFixedSize(true);
        recyclerViewNationals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterNational = new AdapterTMDB(crearListaNationals(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerViewNationals.setAdapter(adapterNational);
        /////////////

        RecyclerView recyclerViewComedies = view.findViewById(R.id.fragment_home_recycler_comedy);
        recyclerViewComedies.setHasFixedSize(true);
        recyclerViewComedies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterComedy = new AdapterTMDB(crearListaComedies(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerViewComedies.setAdapter(adapterComedy);
        ///////////////

       /* RecyclerView recyclerViewBecause = view.findViewById(R.id.fragment_home_recycler_saw);
        recyclerViewBecause.setHasFixedSize(true);
        recyclerViewBecause.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        adapterBecauseYouWatched = new AdapterTMDB(crearListaBecauseYouWatched(), new AdapterTMDB.Notificable() {
            @Override
            public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
            }
        });

        recyclerViewBecause.setAdapter(adapterBecauseYouWatched);*/

        return view;
    }

    //Agrego la lista de pelis a mostrar en la seccion Trending Now. @Dani
    private List<Pelicula> crearTrendingLista() {

        if (listaTrending.size() == 0) {

            PeliculaController peliculaController = new PeliculaController();

            peliculaController.obtenerPeliculas(1, new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {

                    AdapterViewPagerCarrousel adapterViewPagerCarrousel = new AdapterViewPagerCarrousel(getActivity().getSupportFragmentManager(), resultado);
                    viewPager.setAdapter(adapterViewPagerCarrousel);

                    adapterTreinding = new AdapterTMDB(resultado, new AdapterTMDB.Notificable() {
                        @Override
                        public void abrirDetalleContactoClickeado(List<Pelicula> listaPelicula, Integer positionPelicula) {
                            notificable.abrirDetalleContactoClickeado(listaPelicula, positionPelicula);
                        }
                    });

                    recyclerView.setAdapter(adapterTreinding);


                }
            });
        }

        return listaTrending;
    }

    private List<Pelicula> crearListaSerie() {

        if (listaSeries.size() == 0) {



            PeliculaController serieController = new PeliculaController();

            serieController.obtenerSeries(new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    listaSeriesResultado = resultado;
                    //Toast.makeText(getActivity(), listaSeriesResultado.toString(), Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < listaSeriesResultado.size(); i++) {
                        listaSeries.add(crearObjetoPelicula(listaSeriesResultado.get(i)));
                    }
                    adapterSerie.notifyDataSetChanged();
                }
            });
        }

        return listaSeries;
    }

    private List<Pelicula> crearListaReleases() {

        if (listaReleases.size() == 0) {

            PeliculaController releasesController = new PeliculaController();

            releasesController.obtenerPeliculas(2, new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {

                    listaReleasesResultado = resultado;

                    for (int i = 0; i < listaReleasesResultado.size(); i++) {
                        listaReleases.add(crearObjetoPelicula(listaReleasesResultado.get(i)));
                    }

                    adapterReleases.notifyDataSetChanged();

                }
            });

        }

        return listaReleases;
    }

    private List<Pelicula> crearListaNationals() {

        if (listaNational.size() == 0) {

            PeliculaController nationalController = new PeliculaController();

            nationalController.obtenerPeliculas(3, new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {

                    listaNationalResultado = resultado;

                    for (int i = 0; i < listaNationalResultado.size(); i++) {
                        listaNational.add(crearObjetoPelicula(listaNationalResultado.get(i)));
                    }

                    adapterNational.notifyDataSetChanged();
                }
            });

        }

        return listaNational;
    }

    private List<Pelicula> crearListaComedies() {

        if (listaComedy.size() == 0) {
            PeliculaController comedyController = new PeliculaController();

            comedyController.obtenerPeliculas(4, new ResultListener<List<Pelicula>>() {
                @Override
                public void finish(List<Pelicula> resultado) {
                    listaComedyResultado = resultado;

                    for (int i = 0; i < listaComedyResultado.size(); i++) {
                        listaComedy.add(crearObjetoPelicula(listaComedyResultado.get(i)));
                    }
                    adapterComedy.notifyDataSetChanged();
                }
            });
        }

        return listaComedy;
    }

   /* private List<Pelicula> crearListaBecauseYouWatched() {

        List<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lista.add(new Pelicula("Proyecto Rampage", getString(R.string.description_ipsum), "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
            lista.add(new Pelicula("Suicide Squad 2", getString(R.string.description_ipsum), "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
            lista.add(new Pelicula("The Party", getString(R.string.description_ipsum), "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
            lista.add(new Pelicula("Tomb Raider", getString(R.string.description_ipsum), "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
            lista.add(new Pelicula("Verdad o Reto", getString(R.string.description_ipsum), "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg", "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));
        }
        return lista;
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificable = (Notificable) getActivity();
    }

    public interface Notificable {
        void abrirDetalleContactoClickeado(List<Pelicula> peliculas, Integer positionPelicula);
    }

    public Pelicula crearObjetoPelicula(Pelicula unPelicula) {

        return new Pelicula(unPelicula.getTitle(), unPelicula.getOverview(), unPelicula.getPoster_path(), unPelicula.getBackdrop_path());

    }

    public class miTimer extends TimerTask {

        @Override
        public void run() {


            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem() == 4){
                        viewPager.setCurrentItem(5);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }







}