package com.example.dh.contactosonbackonlongpress;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class FragmentAgregarContacto extends Fragment {
    private RecibidorContactoTerminado recibidorContactoTerminado;
    private RecibidorCancelacion recibidorCancelacion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment_agregar_contacto, container, false);
        final TextView buttonCancelar = view.findViewById(R.id.button_cancelar_agregar_contacto);
        final TextView buttonAgregar = view.findViewById(R.id.button_aceptar_agregar_contacto);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recibidorCancelacion.recibirCancelacion();
            }
        });
        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoContacto = view.findViewById(R.id.imageview_contacto_agregar_contacto);

                Contacto contacto = new Contacto(fotoContacto, "asd", "hola");
                recibidorContactoTerminado.RecibirContacto(contacto);
                recibidorCancelacion.recibirCancelacion();
            }
        });
        RadioButton perro = view.findViewById(R.id.radiobutton_perro);
        perro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoContacto = view.findViewById(R.id.imageview_contacto_agregar_contacto);
                fotoContacto.setImageResource(R.drawable.perro);
            }
        });
        RadioButton goku = view.findViewById(R.id.radiobutton_goku);
        goku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoContacto = view.findViewById(R.id.imageview_contacto_agregar_contacto);
                fotoContacto.setImageResource(R.drawable.goku);
            }
        });
        RadioButton persona = view.findViewById(R.id.radiobutton_persona);
        persona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fotoContacto = view.findViewById(R.id.imageview_contacto_agregar_contacto);
                fotoContacto.setImageResource(R.drawable.persona);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        recibidorContactoTerminado = (RecibidorContactoTerminado) context;
        recibidorCancelacion = (RecibidorCancelacion) context;
    }

    public interface RecibidorContactoTerminado {
        public void RecibirContacto(Contacto contacto);
    }

    public interface RecibidorCancelacion {
        public void recibirCancelacion();
    }
}
