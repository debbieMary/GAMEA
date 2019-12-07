package elalto.gamea.artesano.categoria.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import elalto.gamea.R;
import elalto.gamea.artesano.categoria.model.Categoria;
import elalto.gamea.artesano.productos.view.ArtProductosActivity;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {
    private List<Categoria> categoriaArrayList = new ArrayList<>();
    private Context ctx;

    public CategoriaAdapter(List<Categoria> categoriaArrayList, Context ctx) {
        this.categoriaArrayList = categoriaArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_card, parent, false);
        return new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        holder.asignarDatos(categoriaArrayList.get(position));
        holder.imgCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, ArtProductosActivity.class);
                intent.putExtra("idCategoria", String.valueOf(categoriaArrayList.get(position).getId_categoria()));
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriaArrayList.size();
    }


    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategoria;
        TextView tvCategoria;

        public CategoriaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategoria = itemView.findViewById(R.id.img_categoria);
            tvCategoria = itemView.findViewById(R.id.tv_desaparecido);
        }

        public void asignarDatos(Categoria categoria) {
            tvCategoria.setText(categoria.getCategoria());
            Glide.with(ctx).load(categoria.getImagen())
                  .into(imgCategoria);

        }
    }
}
