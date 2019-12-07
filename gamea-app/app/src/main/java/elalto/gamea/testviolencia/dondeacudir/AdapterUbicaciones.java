package elalto.gamea.testviolencia.dondeacudir;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elalto.gamea.R;


public class AdapterUbicaciones extends RecyclerView.Adapter<AdapterUbicaciones.ViewHolderUbicaciones> {
    ArrayList<Ubicaciones> ubicacions;
    private AdapterUbicacionesListener listener;
    Context ctx;

    public AdapterUbicaciones(ArrayList<Ubicaciones> ubicacions, Context ctx, AdapterUbicacionesListener listener) {
        this.ubicacions = ubicacions;
        this.ctx = ctx;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderUbicaciones onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.donde_acudir_item, viewGroup, false);
        return new ViewHolderUbicaciones(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUbicaciones viewHolderUbicaciones, int i) {
        viewHolderUbicaciones.asignarDatos(ubicacions.get(i));
    }

    @Override
    public int getItemCount() {
        return ubicacions.size();
    }


    public class ViewHolderUbicaciones extends RecyclerView.ViewHolder {
        TextView tv_tipo, tv_nombre, tv_distrito, tv_direccion, tv_llamar;
        ImageView imgContactanos;

        public ViewHolderUbicaciones(@NonNull View itemView) {
            super(itemView);
            tv_tipo = itemView.findViewById(R.id.tv_tipo);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_distrito = itemView.findViewById(R.id.tv_distrito);
            tv_direccion = itemView.findViewById(R.id.tv_direccion);
            tv_llamar = itemView.findViewById(R.id.tv_llamar);
            imgContactanos = itemView.findViewById(R.id.img_contactanos);
            imgContactanos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.callDependencia(ubicacions.get(getAdapterPosition()));
                }
            });
            tv_llamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.navigateToMap(ubicacions.get(getAdapterPosition()));
                }
            });

        }

        public void asignarDatos(Ubicaciones ubicacion) {
            tv_tipo.setText(ubicacion.getTipo().toString());
            tv_nombre.setText(ubicacion.getNombre().toString());
            tv_distrito.setText(String.valueOf(ubicacion.getDistrito()));
            tv_direccion.setText(ubicacion.getDireccion());
        }
    }

    public interface AdapterUbicacionesListener {
        void callDependencia(Ubicaciones ubicaciones);
        void navigateToMap(Ubicaciones ubicaciones);
    }
}
