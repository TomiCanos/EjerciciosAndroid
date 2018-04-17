package com.example.dh.recyclerejercicio2;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaObjetos extends Fragment implements Adapter.NotificableDelClickRecycler {

    private List<Producto> productos;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        productos = new ArrayList<>();
        for (int i = 0; i<10; i++){cargarProductos("moto cruda", "$15600", R.drawable.moto);}
        View view = inflater.inflate(R.layout.fragment_fragment_lista_objetos, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_objetos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(productos, this);
        recyclerView.setAdapter(adapter);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.fbutton_agregar_producto);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarProductos("ropero", "$5500", R.drawable.ropero);

            }
        });
        return view;
    }

    private void cargarProductos(String nombre, String precio, Integer foto) {
        Producto producto = new Producto(nombre, precio, foto);
        productos.add(producto);
        }


    @Override
    public void notificarClick(Producto producto) {
        Toast.makeText(getContext(), "producto clickeado: " + producto.getNombre(), Toast.LENGTH_SHORT).show();
        ;
    }
}
