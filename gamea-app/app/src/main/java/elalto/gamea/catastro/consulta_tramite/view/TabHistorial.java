package elalto.gamea.catastro.consulta_tramite.view;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import elalto.gamea.R;
import elalto.gamea.catastro.consulta_tramite.adapter.DerivacionesCatastroAdapter;
import elalto.gamea.catastro.consulta_tramite.entities.Tramite;

public class TabHistorial extends Fragment {
    RecyclerView rvHistorial;
    DerivacionesCatastroAdapter derivacionesCatastroAdapter;
    TextView tv_fecha_salida, tv_descripcion_final;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_historial, container, false);
        Tramite tramite = (Tramite) getArguments().getSerializable("tramite");
        rvHistorial = (RecyclerView) view.findViewById(R.id.rv_flujo_tramite);
        rvHistorial.setHasFixedSize(true);
        rvHistorial.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        derivacionesCatastroAdapter = new DerivacionesCatastroAdapter(tramite.getDerivaciones(), getContext());
        rvHistorial.setAdapter(derivacionesCatastroAdapter);
        tv_fecha_salida = (TextView) view.findViewById(R.id.tv_fecha_salida);
        tv_descripcion_final = (TextView) view.findViewById(R.id.tv_descripcion_final);
        if (tramite.getFinalizacion().size() > 0) {
            tv_fecha_salida.setText(TextUtils.isEmpty(tramite.getFinalizacion().get(0).getFecha_salida().toString()) ? "" : tramite.getFinalizacion().get(0).getFecha_salida().toString());
            tv_descripcion_final.setText(TextUtils.isEmpty(tramite.getFinalizacion().get(0).getDescripcion_final().toString()) ? "" : tramite.getFinalizacion().get(0).getDescripcion_final().toString());
        }
        return view;
    }
}
