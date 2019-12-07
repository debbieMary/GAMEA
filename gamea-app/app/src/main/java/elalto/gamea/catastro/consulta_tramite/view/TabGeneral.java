package elalto.gamea.catastro.consulta_tramite.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import elalto.gamea.R;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;

public class TabGeneral extends Fragment {
    TextView tv_hoja_ruta, tv_tipo, tv_fecha_ingreso, tv_cite, tv_tipo_doc, tv_remitente, tv_cargo_remitente, tv_referencia, tv_cantidad_hojas, tv_cantidad_anexos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_general, container, false);
        Tramite tramite = (Tramite) getArguments().getSerializable("tramite");
        tv_hoja_ruta = (TextView) view.findViewById(R.id.tv_hoja_ruta);
        tv_tipo = (TextView) view.findViewById(R.id.tv_tipo);
        tv_fecha_ingreso = (TextView) view.findViewById(R.id.tv_fec_ingreso);
        tv_cite = (TextView) view.findViewById(R.id.tv_cite);
        tv_tipo_doc = (TextView) view.findViewById(R.id.tv_tipo_doc);
        tv_remitente = (TextView) view.findViewById(R.id.tv_remitente);
        tv_cargo_remitente = (TextView) view.findViewById(R.id.tv_cargo_remitente);
        tv_referencia = (TextView) view.findViewById(R.id.tv_referencia);
        tv_cantidad_hojas = (TextView) view.findViewById(R.id.tv_hojas);
        tv_cantidad_anexos = (TextView) view.findViewById(R.id.tv_anexos);

        tv_hoja_ruta.setText(TextUtils.isEmpty(tramite.getHoja_ruta()) ? "" : tramite.getHoja_ruta());
        tv_tipo.setText(TextUtils.isEmpty(tramite.getHoja_ruta_tipo()) ? "" : tramite.getHoja_ruta_tipo());
        tv_fecha_ingreso.setText(TextUtils.isEmpty(tramite.getFecha_recepcion()) ? "" : tramite.getFecha_recepcion());
        tv_cite.setText(TextUtils.isEmpty(tramite.getNumero_cite()) ? "" : tramite.getNumero_cite());
        tv_tipo_doc.setText(TextUtils.isEmpty(tramite.getTramite()) ? "" : tramite.getTramite());
        tv_remitente.setText(TextUtils.isEmpty(tramite.getRemitente()) ? "" : tramite.getRemitente());
        tv_cargo_remitente.setText(TextUtils.isEmpty(tramite.getCargo_remitente()) ? "" : tramite.getCargo_remitente());
        tv_referencia.setText(TextUtils.isEmpty(tramite.getReferencia()) ? "" : tramite.getReferencia());
        tv_cantidad_hojas.setText(TextUtils.isEmpty(tramite.getCantidad_hojas()) ? "" : tramite.getCantidad_hojas());
        tv_cantidad_anexos.setText(TextUtils.isEmpty(tramite.getNro_anexo()) ? "" : tramite.getNro_anexo());

        return view;
    }
}
