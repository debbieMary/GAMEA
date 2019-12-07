package elalto.gamea.denuncia.misreportes.view;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import elalto.gamea.R;
import elalto.gamea.denuncia.misreportes.adapter.DenunciaAdapter;
import elalto.gamea.denuncia.misreportes.entities.Denuncia;
import elalto.gamea.denuncia.misreportes.model.MisReportesInteractorImpl;
import elalto.gamea.denuncia.misreportes.presenter.MisReportesPresenter;
import elalto.gamea.denuncia.misreportes.presenter.MisReportesPresenterImpl;
import elalto.network.entities.TokenManager;
import es.dmoral.toasty.Toasty;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisReportesFragment extends Fragment implements MisReportesView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_denuncias)
    RecyclerView rvDenuncias;
    public ProgressDialog progressDialog;
    TokenManager tokenManager;
    DenunciaAdapter denunciaAdapter;
    private MisReportesPresenter presenter;

    public MisReportesFragment() {
        // Required empty public constructor
    }

    @SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mis_reportes, container, false);
        ButterKnife.bind(this, view);
        presenter = new MisReportesPresenterImpl(this, new MisReportesInteractorImpl());
        toolbar.setTitle("Mis reportes");
        progressDialog = new ProgressDialog(getActivity());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tokenManager = TokenManager.getInstance(getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE));
        progressDialog.setMessage("Obteniendo informacion...");
        progressDialog.setCancelable(false);
        presenter.getReportes(tokenManager);
        rvDenuncias.setHasFixedSize(true);
        rvDenuncias.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showErrorMessage(String message) {
        Toasty.error(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAdapter(List<Denuncia> denunciaList) {
        denunciaAdapter = new DenunciaAdapter(denunciaList, getContext());
        rvDenuncias.setAdapter(denunciaAdapter);
    }
}
