package elalto.gamea.denuncia.misreportes.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import elalto.gamea.R;
import elalto.gamea.denuncia.misreportes.entities.Denuncia;

public class DenunciaAdapter extends RecyclerView.Adapter<DenunciaAdapter.DenunciaViewHolder> {
    private List<Denuncia> denuncias = new ArrayList<>();
    private Context ctx;

    public DenunciaAdapter(List<Denuncia> denuncias, Context ctx) {
        this.denuncias = denuncias;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public DenunciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_denuncia, parent, false);
        return new DenunciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DenunciaViewHolder holder, int position) {
        holder.asignarDatos(denuncias.get(position));
    }

    @Override
    public int getItemCount() {
        return denuncias.size();
    }

    public class DenunciaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView imgDenuncia;
        TextView tvDistrito, tvZona, tvDescripcion, tvEstado, tvSecretaria, tvPublicado;

        public DenunciaViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linear_estado);
            imgDenuncia = itemView.findViewById(R.id.img_denuncia);
            tvDistrito = itemView.findViewById(R.id.tv_distrito);
            tvZona = itemView.findViewById(R.id.tv_zona);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion);
            tvEstado = itemView.findViewById(R.id.tv_estado);
            tvSecretaria = itemView.findViewById(R.id.tv_secretaria);
            tvPublicado = itemView.findViewById(R.id.tv_publicado);
        }

        @SuppressLint("ResourceAsColor")
        public void asignarDatos(Denuncia denuncia) {
            Glide.with(ctx).load(denuncia.getImg_denuncia().toString()).into(imgDenuncia);
            tvDistrito.setText(String.valueOf(denuncia.getDistrito()));
            tvZona.setText(denuncia.getZona().toString());
            tvDescripcion.setText(denuncia.getDescripcion().toString());
            if (denuncia.getEstado() != null) {
                if (denuncia.getEstado().equals("1")) {
                    tvEstado.setText("Derivado a:");
                }
            } else {
                tvEstado.setText("Pendiente");
            }

            if (denuncia.getNombre_secretaria() != null) {
                tvSecretaria.setText(denuncia.getNombre_secretaria().toString());
            } else {
                tvSecretaria.setVisibility(View.GONE);
            }
            tvPublicado.setText(denuncia.getPublicado());

        }
    }
}
