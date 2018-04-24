package com.example.dh.contactosonbackonlongpress;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaContactos extends Fragment {
    private RecibidorAgregar
            recibidorAgregar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_lista_contactos, container, false);
        FloatingActionButton agregarContacto = view.findViewById(R.id.fbutton_agregar_contacto);
        agregarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recibidorAgregar.recibirAgregar();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        recibidorAgregar = (RecibidorAgregar) context;
    }

    public interface RecibidorAgregar {
        public void recibirAgregar();
    }
}
