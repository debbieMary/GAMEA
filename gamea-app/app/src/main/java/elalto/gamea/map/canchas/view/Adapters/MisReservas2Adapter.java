package elalto.gamea.map.canchas.view.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;
import elalto.gamea.map.canchas.utils.GeneralUtils;
import elalto.gamea.map.canchas.view.DeleteReservaActivity;

public class MisReservas2Adapter extends RecyclerView.Adapter<MisReservas2Adapter.PlanetViewHolder> {

    ArrayList<MisReservas> planetList;
    Context context;
    GeneralUtils generalUtils =  new GeneralUtils();

    public MisReservas2Adapter(ArrayList<MisReservas> planetList, Context context) {
        this.planetList = planetList;
        this.context =  context;
    }

    @Override
    public MisReservas2Adapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mis_reservas,parent,false);
        PlanetViewHolder viewHolder=new PlanetViewHolder(v);
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(MisReservas2Adapter.PlanetViewHolder holder, int position) {
        MisReservas misReservas = planetList.get(position);
        final String nombre_cancha = misReservas.getNombre();
        final int estado = misReservas.getEstado();
        final String fecha = generalUtils.transformDate(misReservas.getFecha().split("T")[0]);
        final String hora_inicio = misReservas.getHora_inicio();
        final int id_reserva = misReservas.getId_reserva();
        final String hora_fin = misReservas.getHora_fin();
        holder.lbl_nombre_cancha.setText(nombre_cancha);
        holder.lbl_fecha.setText(fecha);
        holder.lbl_hora_inicio.setText(hora_inicio);
        holder.lbl_hora_fin.setText(hora_fin);
        if (estado == 1){
            holder.img_estado.setBackgroundResource(R.drawable.img_reservado);
            holder.img_delete.setVisibility(View.VISIBLE);
        } else if ( estado == 2) {
            holder.img_estado.setBackgroundResource(R.drawable.img_pagado);
            holder.img_delete.setVisibility(View.GONE);
        } else if (estado ==3) {
            holder.img_estado.setBackgroundResource(R.drawable.img_rechazado);
            holder.img_delete.setVisibility(View.GONE);
        } else {

        }
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=  new Intent(context, DeleteReservaActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id_reserva", id_reserva);
                i.putExtra("nombre_cancha", nombre_cancha);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder{

        public TextView lbl_nombre_cancha;
        public TextView lbl_fecha;
        public TextView lbl_hora_inicio;
        public TextView lbl_hora_fin;
        public ImageView img_estado, img_delete;

        public PlanetViewHolder(View view) {
            super(view);
            lbl_nombre_cancha = (TextView) view.findViewById(R.id.lbl_nombre_cancha);
            lbl_fecha = (TextView) view.findViewById(R.id.lbl_fecha);
            lbl_hora_inicio = (TextView) view.findViewById(R.id.lbl_hora_inicio);
            lbl_hora_fin = (TextView) view.findViewById(R.id.lbl_hora_fin);
            img_estado = (ImageView) view.findViewById(R.id.img_estado);
            img_delete = (ImageView) view.findViewById(R.id.img_delete);
        }
    }
}