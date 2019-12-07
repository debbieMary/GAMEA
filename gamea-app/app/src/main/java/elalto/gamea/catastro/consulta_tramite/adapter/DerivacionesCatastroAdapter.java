package elalto.gamea.catastro.consulta_tramite.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import elalto.gamea.R;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;

public class DerivacionesCatastroAdapter extends RecyclerView.Adapter<DerivacionesCatastroAdapter.DerivacionesViewHolder> {
    private List<Tramite.DerivacionesBean> derivacionesBeanList = new ArrayList<>();
    private Context ctx;

    public DerivacionesCatastroAdapter(List<Tramite.DerivacionesBean> derivacionesBeanList, Context ctx) {
        this.derivacionesBeanList = derivacionesBeanList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public DerivacionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tramite_card, parent, false);
        return new DerivacionesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DerivacionesViewHolder holder, int position) {
        holder.asignarDatos(derivacionesBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return derivacionesBeanList.size();
    }

    public class DerivacionesViewHolder extends RecyclerView.ViewHolder {
        TextView txvRemitente, txvFechaDerivada, txvDestinatario, txvFechaRecivida, txvDescripcion, txvEstado, txvObservacionesR;

        public DerivacionesViewHolder(@NonNull View itemView) {
            super(itemView);
            txvRemitente = itemView.findViewById(R.id.txv_remitente_f);
            txvFechaDerivada = itemView.findViewById(R.id.txv_fecha_derivada);
            txvDestinatario = itemView.findViewById(R.id.txv_destinatario);
            txvFechaRecivida = itemView.findViewById(R.id.txv_fecha_recivida);
            txvDescripcion = itemView.findViewById(R.id.txv_descripcion);
            txvEstado = itemView.findViewById(R.id.txv_estado);
            txvObservacionesR = itemView.findViewById(R.id.txv_observaciones_r);
        }

        public void asignarDatos(Tramite.DerivacionesBean derivacionesBean) {
            txvRemitente.setText(TextUtils.isEmpty(derivacionesBean.getRemitente()) ? "" : Html.fromHtml(derivacionesBean.getRemitente().toString()));
            txvFechaDerivada.setText(TextUtils.isEmpty(derivacionesBean.getFecha_derivada()) ? "" : Html.fromHtml(derivacionesBean.getFecha_derivada().toString()));
            txvDestinatario.setText(TextUtils.isEmpty(derivacionesBean.getDestinatario()) ? "" : Html.fromHtml(derivacionesBean.getDestinatario().toString()));
            txvFechaRecivida.setText(TextUtils.isEmpty(derivacionesBean.getFecha_recibida()) ? "" : Html.fromHtml(derivacionesBean.getFecha_recibida().toString()));
            txvDescripcion.setText(TextUtils.isEmpty(derivacionesBean.getDescripcion()) ? "" : Html.fromHtml(derivacionesBean.getDescripcion().toString()));
            txvEstado.setText(TextUtils.isEmpty(derivacionesBean.getEstado()) ? "" : Html.fromHtml(derivacionesBean.getEstado().toString()));
            if (derivacionesBean.getObservaciones().equals("0")){
                txvObservacionesR.setText(TextUtils.isEmpty(derivacionesBean.getObservaciones_r())?"":Html.fromHtml(derivacionesBean.getObservaciones_r().toString()));
            }else{
                txvObservacionesR.setText(TextUtils.isEmpty(derivacionesBean.getObservaciones())?"":Html.fromHtml(derivacionesBean.getObservaciones().toString()));
            }
        }

    }
}
