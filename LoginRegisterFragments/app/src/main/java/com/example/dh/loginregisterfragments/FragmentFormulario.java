package com.example.dh.loginregisterfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFormulario extends Fragment {

    private NotificadorAActivities notificador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment_formulario, container, false);
        Button button = view.findViewById(R.id.fragment_formulario_button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = view.findViewById(R.id.fragment_formulario_txtedit_username);
                EditText password = view.findViewById(R.id.fragment_formulario_txtedit_password);
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();
                notificador.RecibirMensaje(usernameString, passwordString);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificador = (NotificadorAActivities) context;
    }

    public interface NotificadorAActivities {
        public void RecibirMensaje(String mensaje, String mensaje2);
    }

}
