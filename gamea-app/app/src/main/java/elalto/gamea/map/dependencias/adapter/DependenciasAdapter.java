package elalto.gamea.map.dependencias.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import elalto.gamea.R;
import elalto.gamea.map.dependencias.entities.Dependencias;

public class DependenciasAdapter extends RecyclerView.Adapter<DependenciasAdapter.DependenciasViewHolder> implements Filterable {
    private Context ctx;
    private List<Dependencias> dependencias = new ArrayList<>();
    private List<Dependencias> dependenciasFiltered = new ArrayList<>();
    private DependenciaAdapterListener listener;

    public DependenciasAdapter(List<Dependencias> dependencias, Context ctx,DependenciaAdapterListener listener) {
        this.dependencias = dependencias;
        this.dependenciasFiltered = dependencias;
        this.ctx = ctx;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DependenciasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dependencia_card, parent, false);
        return new DependenciasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DependenciasViewHolder holder, int position) {
        holder.asignarDatos(dependenciasFiltered.get(position));
    }

    @Override
    public int getItemCount() {
        return dependenciasFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    dependenciasFiltered = dependencias;
                } else {
                    List<Dependencias> filteredList = new ArrayList<>();
                    for (Dependencias row : dependencias) {
                        if (row.getSecretaria().toLowerCase().contains(charString.toLowerCase()) || row.getDependencia().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }
                    dependenciasFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = dependenciasFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                dependenciasFiltered = (List<Dependencias>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class DependenciasViewHolder extends RecyclerView.ViewHolder {
        TextView txvSecretaria, txvDependencia, txvDistrito, txvZona, txvDireccion;

        public DependenciasViewHolder(@NonNull View itemView) {
            super(itemView);
            txvSecretaria = itemView.findViewById(R.id.txv_secretaria);
            txvDependencia = itemView.findViewById(R.id.txv_dependencia);
            txvDistrito = itemView.findViewById(R.id.txv_distrito);
            txvZona = itemView.findViewById(R.id.txv_zona);
            txvDireccion = itemView.findViewById(R.id.txv_direccion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDependenciaSelected(dependenciasFiltered.get(getAdapterPosition()));
                }
            });
        }

        public void asignarDatos(Dependencias dependencia) {
            txvSecretaria.setText(dependencia.getSecretaria().toString());
            txvDependencia.setText(dependencia.getDependencia().toString());
            txvDistrito.setText(String.valueOf(dependencia.getDistrito()));
            txvZona.setText(dependencia.getZona().toString());
            txvDireccion.setText(dependencia.getDireccion().toString());
        }
    }

    public interface DependenciaAdapterListener{
        void onDependenciaSelected(Dependencias dependencia);
    }
}
