package com.example.dh.recyclerejercicio2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaObjetos extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lista_objetos, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_fragment_objetos);
        return view;
    }

}
