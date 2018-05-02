package com.example.oem.entregableandroidcore;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterRecetas extends RecyclerView.Adapter {
    private List<Receta> recetas;
    private Notificable notificable;

    public AdapterRecetas(List<Receta> recetas, Notificable notificable) {
        this.recetas = recetas;
        this.notificable = notificable;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View viewCelda = layoutInflater.inflate(R.layout.celda_receta, parent, false);
        ViewholderRecetas viewholderRecetas = new ViewholderRecetas(viewCelda);
        return viewholderRecetas;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Receta receta =  recetas.get(position);
        ViewholderRecetas viewholderRecetas = (ViewholderRecetas) holder;
        viewholderRecetas.cargarReceta(receta);
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    private class ViewholderRecetas extends RecyclerView.ViewHolder{
        private ImageView fondoReceta;
        private TextView tituloReceta;
        public ViewholderRecetas(View itemView) {
            super(itemView);
            fondoReceta = itemView.findViewById(R.id.imageview_fondo_celda_receta);
            tituloReceta = itemView.findViewById(R.id.textview_titulo_celda_receta);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Receta receta = recetas.get(getAdapterPosition());
                    notificable.abrirDetalleReceta(receta);
                }
            });
        }

        public void cargarReceta(Receta receta){
            fondoReceta.setImageResource(receta.getFoto());
            tituloReceta.setText(receta.getTitulo());
        }
    }

    public interface Notificable {
        void abrirDetalleReceta(Receta receta);
    }

}
