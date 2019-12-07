package elalto.gamea.artesano.productos.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import elalto.gamea.R;
import elalto.gamea.artesano.productos.model.Producto;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private List<Producto> productos = new ArrayList<>();
    private Context ctx;

    public ProductoAdapter(List<Producto> productos, Context ctx) {
        this.productos = productos;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producto_card, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        holder.asingarDatos(productos.get(position));
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + String.valueOf(productos.get(position).getTelefono())));
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProducto, imgCall;
        TextView tvProducto, tvPrecio, tvDescipcion, tvArtesano, tvDireccion, tvTelefono;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCall = itemView.findViewById(R.id.img_call);
            imgProducto = itemView.findViewById(R.id.img_producto);
            tvProducto = itemView.findViewById(R.id.tv_producto);
            tvPrecio = itemView.findViewById(R.id.tv_precio);
            tvDescipcion = itemView.findViewById(R.id.tv_descripcion);
            tvArtesano = itemView.findViewById(R.id.tv_artesano);
            tvDireccion = itemView.findViewById(R.id.tv_direccion);
            tvTelefono = itemView.findViewById(R.id.tv_telefono);
        }

        public void asingarDatos(Producto producto) {
            Glide.with(ctx).load(producto.getImg1())
                  .into(imgProducto);
            tvProducto.setText(producto.getProducto());
            tvPrecio.setText(String.valueOf(producto.getPrecio()) + " Bs.");
            tvDescipcion.setText(producto.getDescripcion());
            tvArtesano.setText(producto.getArtesano());
            tvDireccion.setText("Distrito " + String.valueOf(producto.getDistrito()) + " " + producto.getDireccion());
            tvTelefono.setText(String.valueOf(producto.getTelefono()));
        }
    }
}
