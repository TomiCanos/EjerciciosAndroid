package com.example.oem.entregableandroidcore;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaRecetas extends Fragment implements AdapterRecetas.Notificable {
    private AdapterRecetas adapterRecetas;
    private Notificable2 notificable2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_recetas, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_fragment_recetas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        adapterRecetas = new AdapterRecetas(new BaseDeRecetas().traerListaDeRecetas(), this);

        recyclerView.setAdapter(adapterRecetas);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificable2 = (Notificable2) context;
    }

    @Override
    public void abrirDetalleReceta(Receta receta) {
        notificable2.abrirDetalleReceta2(receta);
    }

    public interface Notificable2{
        public void abrirDetalleReceta2(Receta receta);
    }
}
