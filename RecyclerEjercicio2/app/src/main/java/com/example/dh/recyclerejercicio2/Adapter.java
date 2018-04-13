package com.example.dh.recyclerejercicio2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;


public class Adapter extends RecyclerView.Adapter {
    private List listaProductos;
    private Context context;

    public Adapter(List listaProductos, Context context) {
        this.listaProductos = listaProductos;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Inflater inflater = new Inflater();
        
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    private class viewHolderProductos extends RecyclerView.ViewHolder {
       private TextView nombreProducto;
       private TextView precioProducto;
       private ImageView imagenProducto;
        public viewHolderProductos(View itemView) {
            super(itemView);
            nombreProducto = itemView.findViewById(R.id.txtview_nombre_producto);
            precioProducto = itemView.findViewById(R.id.txtview_precio_producto);
            imagenProducto = itemView.findViewById(R.id.imageview_fondo_producto);
        }
        public void bindProducto(Producto producto){
            nombreProducto.setText(producto.getNombre());
            precioProducto.setText(producto.getPrecio());
            imagenProducto.setImageResource(producto.getImagen());
        }
    }
}
