package elalto.gamea.map.canchas.view.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import elalto.gamea.R;
import elalto.gamea.map.canchas.entities.MisReservas;

public class MisReservasAdapter extends BaseRecyclerViewAdapter<MisReservas, MisReservasAdapter.ViewHolderMisReservas> {

    public Context context;

    public MisReservasAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void onBindViewHolder(MisReservasAdapter.ViewHolderMisReservas holder, int position) {
        super.onBindViewHolder(holder, position);
        MisReservas misReservas = recyclerObjects.get(position);
        final String nombre_cancha = misReservas.getNombre();
        final int estado = misReservas.getEstado();
        final String fecha = misReservas.getFecha();
        final String hora_inicio = misReservas.getHora_inicio();
        final String hora_fin = misReservas.getHora_fin();

        holder.lbl_nombre_cancha.setText(nombre_cancha);
        holder.lbl_fecha.setText(fecha);
        holder.lbl_hora_inicio.setText(hora_inicio);
        holder.lbl_hora_fin.setText(hora_fin);
        if (estado == 1){
            holder.img_estado.setBackgroundResource(R.drawable.img_reservado);
        } else if ( estado == 2) {
            holder.img_estado.setBackgroundResource(R.drawable.img_cancelado);
        } else if (estado ==3) {
            holder.img_estado.setBackgroundResource(R.drawable.img_rechazado);
        } else {

        }
    }

    @Override
    public ViewHolderMisReservas onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mis_reservas, parent, false);
        return new ViewHolderMisReservas(view);
    }


    public class ViewHolderMisReservas extends RecyclerView.ViewHolder {
        public TextView lbl_nombre_cancha;
        public TextView lbl_fecha;
        public TextView lbl_hora_inicio;
        public TextView lbl_hora_fin;
        public ImageView img_estado;

        public ViewHolderMisReservas(View view) {
            super(view);
            lbl_nombre_cancha = (TextView) view.findViewById(R.id.lbl_nombre_cancha);
            lbl_fecha = (TextView) view.findViewById(R.id.lbl_fecha);
            lbl_hora_inicio = (TextView) view.findViewById(R.id.lbl_hora_inicio);
            lbl_hora_fin = (TextView) view.findViewById(R.id.lbl_hora_fin);
            img_estado = (ImageView) view.findViewById(R.id.img_estado);
        }
    }
}

