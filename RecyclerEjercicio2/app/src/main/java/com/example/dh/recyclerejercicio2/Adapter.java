package com.example.dh.recyclerejercicio2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;


public class Adapter extends RecyclerView.Adapter {
    private List listaProductos;
    private NotificableDelClickRecycler notificableDelClickRecycler;

    public Adapter(List listaProductos, NotificableDelClickRecycler notificableDelClickRecycler) {
        this.listaProductos = listaProductos;
        this.notificableDelClickRecycler = notificableDelClickRecycler;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.producto, parent, false);
        ViewHolderProductos viewHolderProductos = new ViewHolderProductos(view);
        return viewHolderProductos;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Producto producto = (Producto) listaProductos.get(position);
        final ViewHolderProductos viewHolderProductos = (ViewHolderProductos) holder;
        viewHolderProductos.bindProducto(producto);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    private class ViewHolderProductos extends RecyclerView.ViewHolder {
        private TextView nombreProducto;
        private TextView precioProducto;
        private ImageView imagenProducto;

        public ViewHolderProductos(View itemView) {
            super(itemView);
            nombreProducto = itemView.findViewById(R.id.txtview_nombre_producto);
            precioProducto = itemView.findViewById(R.id.txtview_precio_producto);
            imagenProducto = itemView.findViewById(R.id.imageview_fondo_producto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Producto producto = (Producto) listaProductos.get(getAdapterPosition());
                    notificableDelClickRecycler.notificarClick(producto);
                }
            });
        }

        public void bindProducto(Producto producto) {
            nombreProducto.setText(producto.getNombre());
            precioProducto.setText(producto.getPrecio());
            imagenProducto.setImageResource(producto.getImagen());
        }
    }

    public interface NotificableDelClickRecycler {
        void notificarClick(Producto producto);
    }
}
