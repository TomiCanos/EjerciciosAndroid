package com.example.dh.claserepasoejercicio1login;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLoginOCrear extends Fragment {
    private NotificarAActivities notificador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment_login_ocrear, container, false);
        Button buttonCrear = view.findViewById(R.id.fragment_loginocrear_button_crear);
        Button buttonLogin = view.findViewById(R.id.fragment_loginocrear_button_login);
        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje = "clickeastecrear";
                notificador.recibirMensaje(mensaje);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "clickeastelogin";
                notificador.recibirMensaje(mensaje);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificador = (NotificarAActivities) context;
    }

    public interface NotificarAActivities{
        public void recibirMensaje (String mensaje);
    }
}
