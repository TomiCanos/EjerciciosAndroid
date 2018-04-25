package com.example.pyaya.app_pelis_pedro;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment implements AdapterSeries.Notificable {

    private AdapterSeries adapterSeries;
    private AdapterPelicula adapterPelicula;
    private AdapterPelicula adapterPelicula2;
    private AdapterPelicula adapterPelicula3;
    private AdapterPelicula adapterPelicula4;
    private AdapterPelicula adapterPelicula5;
    private Notificable2 notificable2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        adapterSeries = new AdapterSeries(crearLista(), this);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewFragment1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setAdapter(adapterSeries);

        //Recycler & AdapterPelicula para Trending Now. @Dani

        adapterPelicula = new AdapterPelicula(crearTrendingLista(), new AdapterPelicula.NotificableDelClickRecycler() {
            @Override
            public void notificaClick(Pelicula pelicula) {
                Toast.makeText(getActivity(), "CLICN ON TRENDING NOW MOVIE", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerViewTrending = view.findViewById(R.id.fragment_home_trending);
        recyclerViewTrending.setHasFixedSize(true);
        recyclerViewTrending.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerViewTrending.setAdapter(adapterPelicula);

        // RELEASES
        adapterPelicula2 = new AdapterPelicula(crearListaReleases(), new AdapterPelicula.NotificableDelClickRecycler() {
            @Override
            public void notificaClick(Pelicula pelicula) {
                Toast.makeText(getActivity(), "CLICN ON TRENDING NOW MOVIE", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerViewReleases = view.findViewById(R.id.recyclerViewlanzamientos);
        recyclerViewReleases.setHasFixedSize(true);
        recyclerViewReleases.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerViewReleases.setAdapter(adapterPelicula2);

        // NATIONALS
        adapterPelicula3 = new AdapterPelicula(crearListaNationals(), new AdapterPelicula.NotificableDelClickRecycler() {
            @Override
            public void notificaClick(Pelicula pelicula) {
                Toast.makeText(getActivity(), "CLICN ON TRENDING NOW MOVIE", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerViewNationals = view.findViewById(R.id.recyclerViewnacionales);
        recyclerViewNationals.setHasFixedSize(true);
        recyclerViewNationals.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerViewNationals.setAdapter(adapterPelicula3);

        //COMEDIES
        adapterPelicula4 = new AdapterPelicula(crearListaComedies(), new AdapterPelicula.NotificableDelClickRecycler() {
            @Override
            public void notificaClick(Pelicula pelicula) {
                Toast.makeText(getActivity(), "CLICN ON TRENDING NOW MOVIE", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerViewComedies = view.findViewById(R.id.recyclerViewcomedias);
        recyclerViewComedies.setHasFixedSize(true);
        recyclerViewComedies.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerViewComedies.setAdapter(adapterPelicula4);

        //BECAUSE YOU WATCHED SAWII
        adapterPelicula5 = new AdapterPelicula(crearListaBecauseYouWatchedSawII(), new AdapterPelicula.NotificableDelClickRecycler() {
            @Override
            public void notificaClick(Pelicula pelicula) {
                Toast.makeText(getActivity(), "CLICN ON TRENDING NOW MOVIE", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerViewBecause = view.findViewById(R.id.recyclerViewporqueviste);
        recyclerViewBecause.setHasFixedSize(true);
        recyclerViewBecause.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerViewBecause.setAdapter(adapterPelicula5);

        return view;
    }

    private List<Serie> crearLista() {

        List<Serie> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++){
        lista.add(new Serie("Deadpool 2", "Deadpool 2", R.drawable.deadpooldos));
        lista.add(new Serie("House of Cards", "House of Cards"));
        lista.add(new Serie("Bambi", "Bambi", R.drawable.bambi));
        lista.add(new Serie("Amadeus", "Amadeus", R.drawable.amadeus));
        lista.add(new Serie("Black Panther", "Black Panther", R.drawable.blackpanther));
        }
        return lista;
    }

    //Agrego la lista de pelis a mostrar en la seccion Trending Now. @Dani
    private List<Pelicula> crearTrendingLista() {

        List<Pelicula> listaTrending = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listaTrending.add(new Pelicula("Forest Gump", "A man with a low IQ has accomplished great things in his life and been present during significant historic events", R.drawable.forrestgump));
            listaTrending.add(new Pelicula("OverBoard", "A spoiled, wealthy yacht owner is thrown overboard and becomes the target of revenge from his mistreated employee. A remake of the 1987 comedy",R.drawable.overboard));
            listaTrending.add(new Pelicula("Horrible Bosses", "For Nick, Kurt and Dale, the only thing that would make the daily grind more tolerable would be to grind their intolerable bosses into dust.", R.drawable.horrible_bosses));
            listaTrending.add(new Pelicula("Just Go With It", "A plastic surgeon, romancing a much younger schoolteacher, enlists his loyal assistant to pretend to be his soon to be ex-wife",R.drawable.just_go_with_it));
        }

        return listaTrending;
    }

    private List<Pelicula> crearListaReleases() {

        List<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            lista.add(new Pelicula("Death Wish", "Death Wish", R.drawable.deathwish));
            lista.add(new Pelicula("En la Sombra", "En la Sombra", R.drawable.enlasombra));
            lista.add(new Pelicula("Flash", "Flash", R.drawable.flash));
            lista.add(new Pelicula("Forrest Gump", "Forrest Gump", R.drawable.forrestgump));
            lista.add(new Pelicula("Jurassic World", "Jurassic World", R.drawable.jurassicworld));
        }
        return lista;
    }

    private List<Pelicula> crearListaNationals() {

        List<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            lista.add(new Pelicula("Just Go With It", "Just Go With It", R.drawable.just_go_with_it));
            lista.add(new Pelicula("La Boveda", "La Boveda", R.drawable.laboveda));
            lista.add(new Pelicula("La Casa de Papel", "La Casa de Papel", R.drawable.lacasadepapel));
            lista.add(new Pelicula("La Monja", "La Monja", R.drawable.lamonja));
            lista.add(new Pelicula("Locos de Amor 2", "Locos de Amor 2", R.drawable.locosdeamordos));
        }
        return lista;
    }

    private List<Pelicula> crearListaComedies() {

        List<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            lista.add(new Pelicula("Noche de Juegos", "Noche de Juegos", R.drawable.nochedejuegos));
            lista.add(new Pelicula("Noche de Venganza", "La Boveda", R.drawable.nochedevenganza));
            lista.add(new Pelicula("Ouija 3", "Ouija 3", R.drawable.ouija3));
            lista.add(new Pelicula("Overboard", "Overboard", R.drawable.overboard));
            lista.add(new Pelicula("Perdida", "Perdida", R.drawable.perdida));
        }
        return lista;
    }

    private List<Pelicula> crearListaBecauseYouWatchedSawII() {

        List<Pelicula> lista = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            lista.add(new Pelicula("Proyecto Rampage", "Proyecto Rampage", R.drawable.proyectorampage));
            lista.add(new Pelicula("Suicide Squad 2", "Suicide Squad 2", R.drawable.suicidesquaddos));
            lista.add(new Pelicula("The Party", "The Party", R.drawable.theparty));
            lista.add(new Pelicula("Tomb Raider", "Tomb Raider", R.drawable.tombraider));
            lista.add(new Pelicula("Verdad o Reto", "Verdad o Reto", R.drawable.verdadoreto));
        }
        return lista;
    }
    @Override
    public void abrirDetalleContactoClickeado(Serie serie) {
        notificable2.abrirDetalleContactoClickeado2(serie);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificable2 = (Notificable2) getActivity();
    }

    public interface Notificable2 {
        void abrirDetalleContactoClickeado2(Serie serie);
    }

}