package elalto.gamea.map.canchas.view.Adapters;

import android.app.Activity;
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
import elalto.gamea.map.canchas.utils.GeneralUtils;
import elalto.gamea.map.canchas.view.DeleteReservaActivity;
import elalto.network.canchas.entities.MisReservas;

import static elalto.gamea.map.canchas.view.MisReservasActivity.DELETE_CONTACT_REQUEST;

public class MisReservasAdapter extends RecyclerView.Adapter<MisReservasAdapter.PlanetViewHolder> {

    ArrayList<MisReservas> planetList;
    Context context;
    GeneralUtils generalUtils =  new GeneralUtils();

    public MisReservasAdapter(ArrayList<MisReservas> planetList, Context context) {
        this.planetList = planetList;
        this.context =  context;
    }

    @Override
    public MisReservasAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mis_reservas,parent,false);
        PlanetViewHolder viewHolder=new PlanetViewHolder(v);
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(MisReservasAdapter.PlanetViewHolder holder, int position) {
        MisReservas misReservas = planetList.get(position);
        final String nombre_cancha = misReservas.getNombre();
        final int estado = misReservas.getEstado();
        final String fecha = generalUtils.transformDate(misReservas.getFecha().split("T")[0]);
        final String hora_inicio = misReservas.getHoraInicio();
        final int id_reserva = misReservas.getIdReserva();
        final String hora_fin = misReservas.getHoraFin();
        holder.lbl_nombre_cancha.setText(nombre_cancha);
        holder.lbl_fecha.setText(fecha);
        holder.lbl_hora_inicio.setText(hora_inicio);
        holder.lbl_hora_fin.setText(hora_fin);
        if (estado == 1){
            holder.img_estado.setBackgroundResource(R.drawable.img_reservado);
        } else if ( estado == 2) {
            holder.img_estado.setBackgroundResource(R.drawable.img_pagado);
        } else if (estado ==3) {
            holder.img_estado.setBackgroundResource(R.drawable.img_rechazado);
        } else {

        }
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
        public ImageView img_estado;

        public PlanetViewHolder(View view) {
            super(view);
            lbl_nombre_cancha = (TextView) view.findViewById(R.id.lbl_nombre_cancha);
            lbl_fecha = (TextView) view.findViewById(R.id.lbl_fecha);
            lbl_hora_inicio = (TextView) view.findViewById(R.id.lbl_hora_inicio);
            lbl_hora_fin = (TextView) view.findViewById(R.id.lbl_hora_fin);
            img_estado = (ImageView) view.findViewById(R.id.img_estado);
        }
    }
}