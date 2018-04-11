
package com.example.dh.floating1;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentActivity1 extends Fragment {

    private NotificadorAActivities notificador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_fragment_activity1, container, false);

        FloatingActionButton floatingActionButton = view.findViewById(R.id.fbbutton_fragment1_enviar_carta);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mensaje = view.findViewById(R.id.txtedit_fragment1_mensaje);
                EditText regalos = view.findViewById(R.id.txtedit_fragment1_regalos);
                String regalosString = regalos.getText().toString();
                String mensajeString = mensaje.getText().toString();
                notificador.recibirMensaje(mensajeString, regalosString);
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
        public void recibirMensaje (String mensaje, String regalos);
    }
}
