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
import com.trabajo_integrador.xilften.model.Pelicula;
import com.trabajo_integrador.xilften.R;


public class FragmentDetalle extends Fragment {

    private static final String ID_PELICULA = "ID_PELICULA";

    private ImageView imagenDetalle;
    private TextView nombreDetalle;
    private TextView descripcionDetalle;
    private ImageButton botonFavoritoFragmentDetalle;
    private Pelicula pelicula;
    //private RecibirPeliculaDesdeElDetalle recibidorPeliculaDesdeElDetalle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        nombreDetalle = view.findViewById(R.id.textViewNombreFragmentDetalle);
        descripcionDetalle = view.findViewById(R.id.textViewDescripcionFragmentDetalle);
        imagenDetalle = view.findViewById(R.id.imagenFragmentDetalle);
        botonFavoritoFragmentDetalle = view.findViewById(R.id.imageButtonFavoritoFragmentDetalle);


        Bundle bundle = getArguments();

        pelicula = (Pelicula) bundle.getSerializable(ID_PELICULA);

        if (pelicula.getEstaEnFavoritos()){botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavoritoclickeado);}
        nombreDetalle.setText(pelicula.getTitle());
        descripcionDetalle.setText(pelicula.getOverview());

        if (pelicula.getBackdrop_path() !=null){
            Picasso.get().load("https://image.tmdb.org/t/p/w780" + pelicula.getBackdrop_path()).into(imagenDetalle);
        }else{
            Picasso.get().load("https://image.tmdb.org/t/p/w780" + pelicula.getPoster_path()).into(imagenDetalle);
        }

        //imagenDetalle.setImageResource(pelicula.getPoster_path());

        botonFavoritoFragmentDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pelicula.getEstaEnFavoritos()) {

                    botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavoritoclickeado);
                    Toast.makeText(getContext(), "Has agregado " + nombreDetalle.getText().toString() + " a favoritos.", Toast.LENGTH_SHORT).show();
                    pelicula.setEstaEnFavoritos(true);
                    //recibidorPeliculaDesdeElDetalle.recibirPeliculaDesdeElDetalle(Pelicula);
                } else {
                    botonFavoritoFragmentDetalle.setImageResource(R.drawable.corazonfavorito);
                    Toast.makeText(getContext(), "Has eliminado " + nombreDetalle.getText().toString() + " de favoritos.", Toast.LENGTH_SHORT).show();
                    pelicula.setEstaEnFavoritos(false);
                    // recibidorPeliculaDesdeElDetalle.recibirPeliculaDesdeElDetalle(Pelicula);
                }
            }
        });

        return view;
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        recibidorPeliculaDesdeElDetalle = (RecibirPeliculaDesdeElDetalle) context;
    }

    public interface RecibirPeliculaDesdeElDetalle{
        void recibirPeliculaDesdeElDetalle(Pelicula Pelicula);
    }*/

    public static FragmentDetalle fabricaFragmentPelicula(Pelicula unPelicula) {

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ID_PELICULA, unPelicula);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }

}