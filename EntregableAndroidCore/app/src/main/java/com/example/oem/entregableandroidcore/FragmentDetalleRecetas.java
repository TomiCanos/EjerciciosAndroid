package com.example.oem.entregableandroidcore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleRecetas extends Fragment {

    public static final String CLAVE_RECETA = "recetaADetallar" ;

    private TextView titulo;
    private ImageView foto;
    private TextView ingredientes;
    private TextView preparacion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_detalle_recetas, container, false);
        Bundle bundle = getArguments();
        Receta receta = (Receta) bundle.getSerializable("recetaADetallar");

        titulo = view.findViewById(R.id.txtview_titulo_detalle_receta);
        foto = view.findViewById(R.id.imageview_foto_detalle_receta);
        ingredientes = view.findViewById(R.id.txtview_ingredientes_detalle_receta);
        preparacion = view.findViewById(R.id.txtview_preparacion_detalle_receta);

        String tituloString = receta.getTitulo();
        Integer fotoInteger = receta.getFoto();
        String ingredientesString = receta.getIngredientes();
        String preparacionString = receta.getPreparacion();

        titulo.setText(tituloString);
        foto.setImageResource(fotoInteger);
        ingredientes.setText(ingredientesString);
        preparacion.setText(preparacionString);

        return view;
    }

}
