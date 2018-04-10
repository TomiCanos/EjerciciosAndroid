package com.example.dh.claserepasoejercicio1login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWelcome extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_welcome, container, false);
        Bundle bundle = getArguments();
        TextView textView = view.findViewById(R.id.fragment_welcome_txtview);
        String correoElectronico = bundle.getString("CLAVE_CORREO_ELECTRONICO_CREAR");
        String password = bundle.getString("CLAVE_PASSWORD_CREAR");
        textView.setText("Welcome usuario: " + correoElectronico + " password: " + password);
        return view;
    }

}
