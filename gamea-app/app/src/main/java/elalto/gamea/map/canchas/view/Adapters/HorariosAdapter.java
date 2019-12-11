package elalto.gamea.map.canchas.view.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.Horarios;
import elalto.gamea.map.canchas.entities.MisReservas;

public class HorariosAdapter extends RecyclerView.Adapter<HorariosAdapter.PlanetViewHolder> {

    ArrayList<Horarios> planetList;
    Context context;

    public HorariosAdapter(ArrayList<Horarios> planetList, Context context) {
        this.planetList = planetList;
        this.context =  context;
    }

    @Override
    public HorariosAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horarios_disponibles,parent,false);
        PlanetViewHolder viewHolder=new PlanetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HorariosAdapter.PlanetViewHolder holder, int position) {
        Horarios horarios = planetList.get(position);
        final String hora= horarios.getHora();
        final String estado = horarios.getEstado();

        holder.lbl_hora.setText(hora);
        if (estado.equals("1")){
            holder.ly_estado.setBackgroundResource(R.color.amarilloTrans);
        } else {
            holder.ly_estado.setBackgroundResource(R.color.colorWhite);
        }
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout ly_estado;
        public TextView lbl_hora;

        public PlanetViewHolder(View view) {
            super(view);
            ly_estado = (LinearLayout) view.findViewById(R.id.ly_estado);
            lbl_hora = (TextView) view.findViewById(R.id.lbl_hora);
        }
    }
}