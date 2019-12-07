package elalto.gamea.yayo.listperson.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import elalto.gamea.yayo.listperson.entities.Desaparecido;

public class DesaparecidosAdapter extends RecyclerView.Adapter<DesaparecidosAdapter.DesaparecidosViewHolder> {
    private List<Desaparecido> desaparecidos = new ArrayList<>();
    private Context ctx;

    public DesaparecidosAdapter(List<Desaparecido> desaparecidos, Context ctx) {
        this.desaparecidos = desaparecidos;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public DesaparecidosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_desaparecido, parent, false);
        return new DesaparecidosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesaparecidosViewHolder holder, int position) {
        holder.asignarDatos(desaparecidos.get(position));
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + desaparecidos.get(position).getUsuario().getCelular()));
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return desaparecidos.size(); }

    public class DesaparecidosViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDesaparecido, imgCall;
        TextView tvEdad, tvGenero, tvDesaparecioInmediaciones, tvDetalles, tvUsuario, tvCelular, tvTelefono, tvPublicado, tvDesaparecido;

        public DesaparecidosViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCall = itemView.findViewById(R.id.img_call);
            imgDesaparecido = itemView.findViewById(R.id.img_denuncia);
            tvEdad = itemView.findViewById(R.id.tv_edad);
            tvGenero = itemView.findViewById(R.id.tv_genero);
            tvDesaparecioInmediaciones = itemView.findViewById(R.id.tv_desaparecio_inmediaciones);
            tvDetalles = itemView.findViewById(R.id.tv_desaparecio_inmediaciones);
            tvUsuario = itemView.findViewById(R.id.tv_usuario);
            tvCelular = itemView.findViewById(R.id.tv_celular);
            tvTelefono = itemView.findViewById(R.id.tv_telefono);
            tvPublicado = itemView.findViewById(R.id.tv_publicado);
            tvDesaparecido = itemView.findViewById(R.id.tv_desaparecido);
        }

        public void asignarDatos(Desaparecido desaparecido) {
            Glide.with(ctx).load(desaparecido.getImg().toString()).into(imgDesaparecido);

            tvEdad.setText(String.valueOf(desaparecido.getEdad()));
            tvGenero.setText(desaparecido.getGenero());
            tvDesaparecioInmediaciones.setText(desaparecido.getDesaparecio_inmediaciones());
            tvDetalles.setText(desaparecido.getDetalles());
            tvUsuario.setText(desaparecido.getUsuario().getUsuario());
            tvCelular.setText(String.valueOf(desaparecido.getUsuario().getCelular()));
            tvTelefono.setText(String.valueOf(desaparecido.getTel_contacto()));
            tvPublicado.setText("Publicado " + desaparecido.getCreado().toString());
            tvDesaparecido.setText(desaparecido.getNombres_desaparecidos() + " " + desaparecido.getApellidos_desaparecidos());


        }
    }
}
