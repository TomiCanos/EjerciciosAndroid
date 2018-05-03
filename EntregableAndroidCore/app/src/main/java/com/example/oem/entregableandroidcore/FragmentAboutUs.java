package com.example.oem.entregableandroidcore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAboutUs extends Fragment {
    private TextView textoAboutUs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_about_us, container, false);

        textoAboutUs = view.findViewById(R.id.txtview_texto_fragment_about_us);
        textoAboutUs.setText("Les damos recetas piolas");
        return view;
    }

}
