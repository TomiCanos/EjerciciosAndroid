package com.example.dh.claserepasoejercicio1login;


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
public class FragmentCrear extends Fragment {
    private NotificarAActivities2 notificador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_crear, container, false);
        final EditText correoElectronico = view.findViewById(R.id.fragment_crear_txtedit_direccion_correo_electronico);
        final EditText password = view.findViewById(R.id.fragment_crear_txtedit_password);
        final EditText repetirPassword = view.findViewById(R.id.fragment_crear_txtedit_repetir_password);
        Button crear = view.findViewById(R.id.fragment_crear_button_crear);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String correoElectronicoString = correoElectronico.getText().toString();
              String passwordString = password.getText().toString();
              String rePasswordString = repetirPassword.getText().toString();
              notificador.recibirMensaje2(correoElectronicoString, passwordString, rePasswordString);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificador = (NotificarAActivities2) context;
    }

    public interface NotificarAActivities2{
        public void recibirMensaje2 (String correoElectronico, String password, String repassword);
    }
}
