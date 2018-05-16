package com.trabajo_integrador.xilften.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.trabajo_integrador.xilften.R;
import com.trabajo_integrador.xilften.model.Serie.Serie;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleSerie extends Fragment {
    private static final String ID_SERIE = "ID_SERIE";

    private ImageView imagenDetalle;
    private TextView nombreDetalle;
    private TextView descripcionDetalle;
    private ImageButton botonFavoritoFragmentDetalle;
    private Serie serie;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_detalle_serie, container, false);

        nombreDetalle = view.findViewById(R.id.textViewNombreFragmentDetalle_Serie);
        descripcionDetalle = view.findViewById(R.id.textViewDescripcionFragmentDetalleSerie);
        imagenDetalle = view.findViewById(R.id.imagenFragmentDetalle_Serie);
        botonFavoritoFragmentDetalle = view.findViewById(R.id.imageButtonFavoritoFragmentDetalle_Serie);


        Bundle bundle = getArguments();

        serie = (Serie) bundle.getSerializable(ID_SERIE);

        if (serie.getEstaEnFavoritos()){botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavoritoclickeado);}
        nombreDetalle.setText(serie.getOriginal_name());
        descripcionDetalle.setText(serie.getOverview());

        if (serie.getBackdrop_path() !=null){
            Picasso.get().load("https://image.tmdb.org/t/p/w780" + serie.getBackdrop_path()).into(imagenDetalle);
        }else{
            Picasso.get().load("https://image.tmdb.org/t/p/w780" + serie.getPoster_path()).into(imagenDetalle);
        }

        botonFavoritoFragmentDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!serie.getEstaEnFavoritos()) {

                    botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavoritoclickeado);
                    Toast.makeText(getContext(), "Has agregado " + nombreDetalle.getText().toString() + " a favoritos.", Toast.LENGTH_SHORT).show();
                    serie.setEstaEnFavoritos(true);
                } else {
                    botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavorito);
                    Toast.makeText(getContext(), "Has eliminado " + nombreDetalle.getText().toString() + " de favoritos.", Toast.LENGTH_SHORT).show();
                    serie.setEstaEnFavoritos(false);
                }
            }
        });

        return view;
    }

    public static FragmentDetalleSerie fabricaFragmentSerie(Serie unSerie) {

        FragmentDetalleSerie fragmentDetalle = new FragmentDetalleSerie();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ID_SERIE, unSerie);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }

}
